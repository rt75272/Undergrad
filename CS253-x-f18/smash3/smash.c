  #include <string.h>
  #include <stdio.h>
  #include <stdlib.h>
  #include <unistd.h>
  #include <sys/wait.h>
  #include <errno.h>
  #include <time.h>
  #include "history.h"
  #define MAXLINE 1024
  #define MAXARGS 1024

  char* strncpy_safe(char *dst, const char *src, size_t len) {
        char *rval = NULL;
	rval = strncpy(dst, src, len);
  	rval[len - 1] = '\0';
  	return rval;
  }
	
  char** chop_line_exec(const char* line) {
  	char *token = NULL;
  	int i = 0;
  	char linecpy[MAXLINE];
  	char **rval = malloc(MAXARGS);
  	memset(rval, 0, MAXARGS);
  	strncpy_safe(linecpy, line, MAXLINE);
  	token = strtok(linecpy, " ");
	
  	for(i = 0; token && i < MAXARGS; i++) {
		fprintf(stderr, "got token %s\n", token);
		rval[i] = malloc(MAXLINE);
		strncpy_safe(rval[i], token, MAXLINE);
		token = strtok(NULL, " ");
     	}
      	return rval;
  }
  
  void smash_cd(char *token) {
      	int changeDirectory;
      	char *path;	
      	changeDirectory = chdir(token);
      	path = getcwd(NULL, 0);
	
	if(token != NULL) {
		if(changeDirectory != 0 || path == NULL) {
	      		printf("error: %s does not exist.\n", token);
	  	}
	 	else {
	      		printf("%s\n", path);
	  	}
      	}
  }

  void smash_exit() {
     	 exit(0);
  }
  
  void smash_exec(char** args) {  
	pid_t pid;
	int status;
	const char* s = getenv("CHAOS_MONKEY_DISABLE");
	int r = rand() % 100;
	
	if(s || r <= 75) {
		if ((pid = fork()) < 0) {
			perror("fork");
			exit(errno);
		} 
		else if (pid == 0) { 
			execvp(args[0], args);
			exit(0);
		}
		if(waitpid(pid, &status, 0) != pid) {
			perror("waitpid");
			exit(errno);
		}
	}
	printf("PATH : %s\n", (s != NULL)? s : "getenv returned NULL");
  }
  
  int main(int argc, char **argv) {
  	struct history* history;
  	char buffer[MAXLINE];
	srand(time(NULL));
      	fprintf(stderr, "$ ");
      	history = init_history(100);
      
      	while ((fgets(buffer, MAXLINE, stdin)) != NULL) {
		buffer[strlen(buffer) - 1] = '\0';
		add_history(history, buffer);
	  	char** args = chop_line_exec(buffer);
	  
	  	if(args[0] != NULL) {
	      		if(strcmp(args[0], "exit") == 0) {
		  		smash_exit();
		  		break;
	      		}
	      		else if(strcmp(args[0], "cd") == 0) {	
		  		smash_cd(args[1]);
	      		}
	      		else if(strcmp(args[0], "history") == 0) {
		  		print_history(history);
	      		}
	      		else {
 				smash_exec(args);		   		
	      		}
	  	}
		fprintf(stderr, "$ ");
      }
      clear_history(history);
      return EXIT_SUCCESS;
  }
  