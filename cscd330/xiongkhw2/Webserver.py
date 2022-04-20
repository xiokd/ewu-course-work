# Import socket module
from socket import *

# In order to terminate the program
import sys

serverSocket = socket(AF_INET, SOCK_STREAM)

# Prepare a server socket to bind an IP and listen for one connection
serverSocket.bind(("127.0.0.1", 6789))
serverSocket.listen(True)

while True:
    print("The server is ready to receive")

    # Establish the connection
    connectionSocket, addr = serverSocket.accept()

    try:
        # Receives the request message from the client (bytes that will be need to be decoded)
        message = connectionSocket.recv(1024).decode()

        # Extract the path of the requested object
        fileName = message.split()[1]
        f = open(fileName[1:])

        # Storing contents to temporary buffer
        outputdata = f.read()

        # Send one HTTP header line into the socket
        connectionSocket.send("HTTP/1.1 200 OK\r\n\r\n".encode())

        # Send the content of the requested file to the client
        for i in range(0, len(outputdata)):
            connectionSocket.send(outputdata[i].encode())
        connectionSocket.send("\r\n\r\n".encode())

        # Close the connection socket
        connectionSocket.close()

    except IOError:
        # Send HTTP response message for file not found (HTTP type and status code)
        connectionSocket.send("HTTP/1.1 404 Not Found\r\n\r\n".encode())
        connectionSocket.send("<html><head><title>Not Found</title></head><body><p><b>404 Not Found</b><p></body></html>\r\n\r\n".encode())

        # Close client socket
        connectionSocket.close()
    
    # Close server socket
    serverSocket.close()

    # Terminate program after sending the corresponding data
    sys.exit()