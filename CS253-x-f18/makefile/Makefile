CFLAGS = -Wall -std=c99

-include *.d

all: myprog

myprog: main.o f1.o f2.o f3.o 
	gcc $(CFLAGS) $^ -o $@

clean:
	rm -f *.o myprog