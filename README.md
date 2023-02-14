# LIRR_RouteApp
The task at hand was to take xml files that would have a branch station hierarchy and read them into proper data structures. Then create a gui that will allow the user
to enter a station name from any given branch and output to the user what other branches stem from that if any. My solution was to store each of the xml files which repersented the branch and the stations under the branch into an array. I would then create another array that will contain the arrays that stored the xml files. Doing this would allow me to easily search through each array and the values the array to find a match to what the user entered. For every match, I would display the branch name and the stations under it.


NOTE - All of the xml files are needed for the application to run, as well as JavaFx will need to be installed.
