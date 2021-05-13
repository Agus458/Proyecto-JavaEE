let users = [];

function getUsers() {
    return users;
}

function getUserByNick(nick) {
    return users.filter(user => {
        return user.nick === nick;
    });
}

function addUser(id, nick) {
    let newUser = {
        id,
        nick
    }
    users.push(newUser);
}

function removeUser(id) {
    let userId = users.findIndex(elem => {
        return elem.id === id;
    });
    users.splice(userId, 1);
}

module.exports = { getUserByNick, getUsers, addUser, removeUser }