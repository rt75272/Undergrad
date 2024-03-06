  #ifndef __HISTORY_H
  #define __HISTORY_H
  
  struct cmd {
	  char* cmd;
  };

  struct history {
  	unsigned int size;
    	unsigned int index;
    	struct cmd **arrayList;
  };

  struct history* init_history(int);
  void add_history(struct history *, char *);
  void clear_history(struct history *);
  void print_history(struct history *);

  #endif /* __HISTORY_H */