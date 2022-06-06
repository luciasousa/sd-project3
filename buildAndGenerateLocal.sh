echo "Compiling source code."
javac -cp genclass.jar */*.java */*/*.java
echo "Distributing intermediate code to the different execution environments."
echo "  RMI registry"
rm -rf dirRMIRegistry/interfaces
mkdir -p dirRMIRegistry/interfaces
cp interfaces/*.class dirRMIRegistry/interfaces
echo "  Register Remote Objects"
rm -rf dirRegistry/serverSide dirRegistry/interfaces
mkdir -p dirRegistry/serverSide dirRegistry/serverSide/main dirRegistry/serverSide/objects dirRegistry/interfaces
cp serverSide/main/ServerRegisterRemoteObject.class dirRegistry/serverSide/main
cp serverSide/objects/RegisterRemoteObject.class dirRegistry/serverSide/objects
cp interfaces/Register.class dirRegistry/interfaces
echo "  General Repository of Information"
rm -rf dirGeneralRepos/serverSide dirGeneralRepos/clientSide dirGeneralRepos/interfaces
mkdir -p dirGeneralRepos/serverSide dirGeneralRepos/serverSide/main dirGeneralRepos/serverSide/objects dirGeneralRepos/interfaces \
         dirGeneralRepos/clientSide dirGeneralRepos/clientSide/entities
cp serverSide/main/SimulPar.class serverSide/main/ServerSleepingBarbersGeneralRepos.class dirGeneralRepos/serverSide/main
cp serverSide/objects/GeneralRepos.class dirGeneralRepos/serverSide/objects
cp interfaces/Register.class interfaces/GeneralReposInterface.class dirGeneralRepos/interfaces
cp clientSide/entities/BarberStates.class clientSide/entities/CustomerStates.class dirGeneralRepos/clientSide/entities
echo "  Bar"
rm -rf dirBar/serverSide dirBar/clientSide dirBar/interfaces dirBar/commInfra
mkdir -p dirBar/serverSide dirBar/serverSide/main dirBar/serverSide/objects dirBar/interfaces \
         dirBar/clientSide dirBar/clientSide/entities dirBar/commInfra
cp serverSide/main/Constants.class serverSide/main/ServerBar.class dirBar/serverSide/main
cp serverSide/objects/Bar.class serverSide/objects/Table.class serverSide/objects/Kitchen.class dirBar/serverSide/objects
cp interfaces/*.class dirBar/interfaces
cp clientSide/entities/WaiterStates.class clientSide/entities/StudentStates.class clientSide/entities/ChefStates.class dirBar/clientSide/entities
cp commInfra/*.class dirBar/commInfra
echo "  Table"
rm -rf dirTable/serverSide dirTable/clientSide dirTable/interfaces dirTable/commInfra
mkdir -p dirTable/serverSide dirTable/serverSide/main dirTable/serverSide/objects dirTable/interfaces \
         dirTable/clientSide dirTable/clientSide/entities dirTable/commInfra
cp serverSide/main/Constants.class serverSide/main/ServerTable.class dirTable/serverSide/main
cp serverSide/objects/Table.class dirTable/serverSide/objects
cp interfaces/*.class dirTable/interfaces
cp clientSide/entities/WaiterStates.class clientSide/entities/StudentStates.class dirTable/clientSide/entities
cp commInfra/*.class dirTable/commInfra
echo "  Kitchen"
rm -rf dirKitchen/serverSide dirKitchen/clientSide dirKitchen/interfaces dirKitchen/commInfra
mkdir -p dirKitchen/serverSide dirKitchen/serverSide/main dirKitchen/serverSide/objects dirKitchen/interfaces \
         dirKitchen/clientSide dirKitchen/clientSide/entities dirKitchen/commInfra
cp serverSide/main/Constants.class serverSide/main/ServerKitchen.class dirKitchen/serverSide/main
cp serverSide/objects/Kitchen.class dirKitchen/serverSide/objects
cp interfaces/*.class dirKitchen/interfaces
cp clientSide/entities/WaiterStates.class clientSide/entities/ChefStates.class dirKitchen/clientSide/entities
cp commInfra/*.class dirKitchen/commInfra
echo "  Chef"
rm -rf dirChef/serverSide dirChef/clientSide dirChef/interfaces
mkdir -p dirChef/serverSide dirChef/serverSide/main dirChef/clientSide dirChef/clientSide/main dirChef/clientSide/entities \
         dirChef/interfaces
cp serverSide/main/Constants.class dirChef/serverSide/main
cp clientSide/main/ClientChef.class dirChef/clientSide/main
cp clientSide/entities/Chef.class clientSide/entities/ChefStates.class dirChef/clientSide/entities
cp interfaces/KitchenInterface.class interfaces/GeneralReposInterface.class dirChef/interfaces
echo "  Waiter"
rm -rf dirWaiter/serverSide dirWaiter/clientSide dirWaiter/interfaces
mkdir -p dirWaiter/serverSide dirWaiter/serverSide/main dirWaiter/clientSide dirWaiter/clientSide/main dirWaiter/clientSide/entities \
         dirWaiter/interfaces
cp serverSide/main/Constants.class dirWaiter/serverSide/main
cp clientSide/main/ClientWaiter.class dirWaiter/clientSide/main
cp clientSide/entities/Waiter.class clientSide/entities/WaiterStates.class dirWaiter/clientSide/entities
cp interfaces/BarInterface.class interfaces/GeneralReposInterface.class dirWaiter/interfaces
echo "  Student"
rm -rf dirStudent/serverSide dirStudent/clientSide dirStudent/interfaces
mkdir -p dirStudent/serverSide dirStudent/serverSide/main dirStudent/clientSide dirStudent/clientSide/main dirStudent/clientSide/entities \
         dirStudent/interfaces
cp serverSide/main/Constants.class dirStudent/serverSide/main
cp clientSide/main/ClientStudent.class dirStudent/clientSide/main
cp clientSide/entities/Student.class clientSide/entities/StudentStates.class dirStudent/clientSide/entities
cp interfaces/TableInterface.class interfaces/GeneralReposInterface.class dirStudent/interfaces
echo "Compressing execution environments."
echo " Genclass"
rm -f genclass.zip
zip -rq genclass.zip genclass
echo "  RMI registry"
rm -f  dirRMIRegistry.zip
zip -rq dirRMIRegistry.zip dirRMIRegistry
echo "  Register Remote Objects"
rm -f  dirRegistry.zip
zip -rq dirRegistry.zip dirRegistry
echo "  General Repository of Information"
rm -f  dirGeneralRepos.zip
zip -rq dirGeneralRepos.zip dirGeneralRepos
echo "  Bar"
rm -f  dirBar.zip
zip -rq dirBar.zip dirBar
echo "  Kitchen"
rm -f  dirKitchen.zip
zip -rq dirKitchen.zip dirKitchen
echo "  Table"
rm -f  dirTable.zip
zip -rq dirTable.zip dirTable
echo "  Chef"
rm -f  dirChef.zip
zip -rq dirChef.zip dirChef
echo "  Waiter"
rm -f  dirWaiter.zip
zip -rq dirWaiter.zip dirWaiter
echo "  Student"
rm -f  dirStudent.zip
zip -rq dirStudent.zip dirStudent
echo "Deploying and decompressing execution environments."
mkdir -p ~/test/Restaurant
rm -rf ~/test/Restaurant/*
cp dirRegistry.zip ~/test/Restaurant
cp dirGeneralRepos.zip ~/test/Restaurant
cp dirBar.zip ~/test/Restaurant
cp dirKitchen.zip ~/test/Restaurant
cp dirTable.zip ~/test/Restaurant
cp dirChef.zip ~/test/Restaurant
cp dirWaiter.zip ~/test/Restaurant
cp dirStudent.zip ~/test/Restaurant
cd ~/test/Restaurant
unzip -q dirRegistry.zip
mv set_rmiregistry_alt.sh ~/
unzip -q dirGeneralRepos.zip
unzip -q dirBar.zip
unzip -q dirKitchen.zip
unzip -q dirTable.zip
unzip -q dirWaiter.zip
unzip -q dirChef.zip
unzip -q dirStudent.zip
