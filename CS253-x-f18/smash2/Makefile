
CC = gcc
CFLAGS = -Wall -g 

#-00 -std=c99

all: smash

smash: smash.o history.o
	$(CC) $(CFLAGS) $^ -o $@

clean:
	rm -f *.o smash