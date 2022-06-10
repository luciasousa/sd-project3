xterm  -T "RMI registry" -hold -e "./RMIRegistryDeployAndRun.sh" &
sleep 4
xterm  -T "Registry" -hold -e "./RegistryDeployAndRun.sh" &
sleep 4
xterm  -T "General Repository" -hold -e "./GeneralReposDeployAndRun.sh" &
sleep 4
xterm  -T "Kitchen" -hold -e "./KitchenDeployAndRun.sh" &
sleep 2
xterm  -T "Table" -hold -e "./TableDeployAndRun.sh" &
sleep 2
xterm  -T "Bar" -hold -e "./BarDeployAndRun.sh" &
sleep 2
xterm  -T "Chef" -hold -e "./ChefDeployAndRun.sh" &
sleep 2
xterm  -T "Waiter" -hold -e "./WaiterDeployAndRun.sh" &
sleep 2
xterm  -T "Student" -hold -e "./StudentDeployAndRun.sh" &
