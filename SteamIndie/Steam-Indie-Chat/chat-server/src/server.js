const express = require('express');
const socketio = require('socket.io');
const http = require('http');

// Server configuration
const app = express();
const server = http.createServer(app);

app.set('port', process.env.PORT || 3000);
const port = app.get('port');

// Server Start
server.listen(port, function () {
    console.log('listening to requests on port', port);
});

// Socket settings
const options = {
    // Allows connection from other ports
    cors: {
        origin: "*",
        methods: ["GET", "POST"]
    }
}

// Web socket start
const io = socketio(server, options);

// Socket functions in sockets.js
require('./sockets')(io);