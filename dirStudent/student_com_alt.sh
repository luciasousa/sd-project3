CODEBASE="file:///home/"$1"/test/Restaurant/dirStudent/"
java -Djava.rmi.server.codebase=$CODEBASE\
     -Djava.rmi.server.useCodebaseOnly=false\
     clientSide.main.ClientStudent localhost 22150
