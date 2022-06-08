xterm  -T "RMI registry" -hold -e "./dirRMIRegistry/set_rmiregistry_alt.sh" &
sleep 4
xterm  -T "Registry" -hold -e "./dirRegistry/registry_com_alt.sh" &
sleep 4
xterm  -T "General Repository" -hold -e "./dirGeneralRepos/repos_com_alt.sh" &
sleep 2
xterm  -T "Kitchen" -hold -e "./dirKitchen/kitchen_com_alt.sh" &
sleep 2
xterm  -T "Table" -hold -e "./dirTable/table_com_alt.sh" &
sleep 2
xterm  -T "Bar" -hold -e "./dirBar/bar_com_alt.sh" &
sleep 1
xterm  -T "Chef" -hold -e "./dirChef/chef_com_alt.sh" &
xterm  -T "Waiter" -hold -e "./dirWaiter/waiter_com_alt.sh" &
xterm  -T "Student" -hold -e "./dirStudent/student_com_alt.sh" &