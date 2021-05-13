const { getUserByNick, getUsers, addUser, removeUser } = require('./utilities/users');

// Socket functionalities
module.exports = (io) => {

    // Listen for user connections
    io.on('connection', function (socket) {

        // Listen for new user
        socket.on('new user', (nick, callBack) => {

            if (getUserByNick(nick).length === 0) {
                
                addUser(socket.id, nick);

                // Adds the nick to the particular socket
                socket.nick = nick;

                // Sends welcome message to the new user
                socket.emit('message', `Welcome ${nick} to the chat`);

                // Sends a message to all users about the new one
                socket.broadcast.emit('message', `${nick} has joined the chat`);
                io.emit('users', getUsers());

            } else {
                callBack(false);
            }

        });

        // Listen for user message
        socket.on('new message', function (data) {
            let message = {
                from: socket.nick,
                content: data
            }
            io.sockets.emit('new message', message);
        });

        // When a user sends a private message
        socket.on('wisper', function(data) {
            let destinatary = getUserByNick(data.destinatary);
            if(destinatary.length > 0){
                let message = {
                    from: socket.nick,
                    content: data.content
                }

                io.to(destinatary[0].id).emit('wisper', message);
                socket.emit('wisper', message);
            }
        })

        // When user disconnects
        socket.on('disconnect', () => {
            if (socket.nick) {
                removeUser(socket.id);
                socket.broadcast.emit('message', `${socket.nick} has left the chat`);
                io.emit('users', getUsers());
            }
        });
    });

}