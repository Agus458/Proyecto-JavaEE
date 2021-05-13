// Get username and room from URL
const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const nick = urlParams.get('nombre');

if (nick != null && nick != "") {

    // Make connection
    var socket = io('http://localhost:3000/');

    // Envia el nick del usuario
    socket.emit('new user', nick, data => {
        if(!data){
            container.style.display = "none";
        }
    });

    // Elements from DOM
    let messageForm = document.getElementById('messageForm');
    let output = document.getElementById('output');
    let users = document.getElementById('users');
    let container = document.getElementById('container');
    let messageBox = document.getElementById('message');

    socket.on('message', function (message) {
        output.innerHTML += `<p class="text-muted">${message}</p>`;
    });

    // Events
    messageForm.addEventListener('submit', event => {
        event.preventDefault();

        let message = messageBox.value;
        message = message.replace(/\s+/g,' ').trim();
        message = message.split(' ');
        
        if(message[0] === '/w'){
            message.splice(0,1);
            if(message.length >= 2){

                let newMessage = {
                    destinatary: message.splice(0,1).join(),
                    content: message.join(' ')
                }
                
                socket.emit('wisper', newMessage);
            }
        } else {
            socket.emit('new message', message.join(' '));
        }

        messageBox.value = "";
    });

    // Listen for new messages
    socket.on('new message', function (message) {
        output.innerHTML += `<p><strong class="text-primary">${message.from}: </strong>${message.content}</p>`
    });

    // Listen for users
    socket.on('users', function (arr) {
        users.innerHTML = "";
        arr.forEach(elem => {
            users.innerHTML += `<li class="list-group-item">${elem.nick}</li>`;
        });
    });

    socket.on('wisper', function (message) {
        output.innerHTML += `<p class="text-success"><strong>${message.from}: </strong>${message.content}</p>`
    });

} else {
    container.style.display = "none";
}
