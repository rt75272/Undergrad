#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#ifdef _WIN32
#include <windows.h>
#define chdir _chdir
#else
#include <unistd.h>
#endif
#define MAX_LENGTH 1024
#define DELIMS " \t\r\n"

int main(int argc, char *argv[])
{
	char *cmd;
	char line[MAX_LENGTH];
	char str0[120] = "Error /home/JimConrad  /home/RyanThompson317";

	while (1)
	{
    		printf("$ ");
	    	if (!fgets(line, MAX_LENGTH, stdin))
		{
			 break;
		}
    		if ((cmd = strtok(line, DELIMS)))
		{
      			errno = 0;
      			if (strcmp(cmd, "cd") == 0)
	 		{
        			char *arg = strtok(0, DELIMS);
				printf(str0);
        			if (!arg) fprintf(stderr, "Error - cd command.\n");
        		else chdir(arg);
      		} 
		else if (strcmp(cmd, "exit") == 0)
 		{
        		break;
		}
 		else system(line);

      			if (errno) perror("Error");
    		}
	}
	return 0;
}
