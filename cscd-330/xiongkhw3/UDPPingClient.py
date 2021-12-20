import sys, time
from socket import *

# Get the server hostname and port as command line arguments
argv = sys.argv
host = argv[1]
port = argv[2]

# Timeout in seconds
timeout = 1

# Create UDP client socket
clientsocket = socket(AF_INET, SOCK_DGRAM)

# Set socket timeout as 1 second
clientsocket.settimeout(1.0)

# Command line argument is a string, change the port into integer
port = int(port)

# Sequence number of the ping message
ptime = 0

# Using ptime ping for 10 times
while ptime < 10:
    ptime += 1

    # Format the message to be sent
    data = "Ping " + str(ptime) + " " + time.asctime()

    try:
        # Sent time
        RTTb = time.time()

        # Send the UDP packet with the ping message
        clientsocket.sendto(data.encode(), (host, port))

        # Receive the server response
        message, address = clientsocket.recvfrom(1024)

        # Received time
        RTTa = time.time()

        # Display the server response as an output. This is a print statement
        print("Reply from " + host + ": " + message.decode())

        # Round trip time is the difference between sent and received time in a print statement
        RTTelapsed = RTTa - RTTb
        print("RTT: " + str(RTTelapsed))

    except:
        # Server does not respond
        # Assume the packet is lost
        print("Request timed out.")
        continue

# Close the client socket
clientsocket.close()
sys.exit()
