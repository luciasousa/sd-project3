CODEBASE="file:///home/"$1"/test/Restaurant/dirChef/"
java -Djava.rmi.server.codebase=$CODEBASE\
     -Djava.rmi.server.useCodebaseOnly=false\
     clientSide.main.ClientChef localhost 22150 stat 3
