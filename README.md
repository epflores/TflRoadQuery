# TflRoadQuery
Find up-to-date information on UK roads

This Java application accesses data provided by TfL  open data REST API at [https://api.tfl.gov.uk](https://api.tfl.gov.uk) to query data on the status of UK roads.

# Dropbox

All files listed are available to download via Dropbox:

|       Type         |File                          |Download                         |
|----------------|-------------------------------|-----------------------------|
|Executable Jar|TflRoadQuery.jar            |[dropbox link](https://www.dropbox.com/s/y9zkyqgg88tyuol/TflRoadQuery.jar?dl=0)            |
|Eclipse Project Workspace          |tfl-workspace.zip            |[dropbox link](https://www.dropbox.com/s/sp648mclfxywbco/tfl-workspace.zip?dl=0)            |
|Screenshots | screenshots.png | [dropbox link](https://www.dropbox.com/s/86fbio5n2oz54z9/screenshots.PNG?dl=0)


# Github

All files listed are available to view via GitHub: 

|       File         |Comment                          |Download                         |
|----------------|-------------------------------|-----------------------------|
|TflRoadQuery.java|Main Class            |[https://github.com/epflores/TflRoadQuery/blob/master/TflRoadQuery.java](https://github.com/epflores/TflRoadQuery/blob/master/TflRoadQuery.java)            |
|TflRoadQueryTest.java          |JUnit Test Class            |[https://github.com/epflores/TflRoadQuery/blob/master/TflRoadQueryTest.java](https://github.com/epflores/TflRoadQuery/blob/master/TflRoadQueryTest.java)            |
|config.properties          |Configuration Properties|[https://github.com/epflores/TflRoadQuery/blob/master/config.properties](https://github.com/epflores/TflRoadQuery/blob/master/config.properties)|
|TflProperties.java | config properties Generator Class | [https://github.com/epflores/TflRoadQuery/blob/master/TflProperties.java](https://github.com/epflores/TflRoadQuery/blob/master/TflProperties.java)
|AbstractMainTests.java | JUnit Helper Class | [https://github.com/epflores/TflRoadQuery/blob/master/AbstractMainTests.java](https://github.com/epflores/TflRoadQuery/blob/master/AbstractMainTests.java) |



# Assumptions

1. Validation of road naming rule applied:
	* A-roads have one, two, three or four digits
	* B-roads only have three or four digits to their numbers

# Configuration file

|       Key         |Value                          |Comment                         |
|----------------|-------------------------------|-----------------------------|
|name|Eugene Flores's App            |TFL Registration Name            |
|description          |Default application created on signup.            |TFL Registration Description            |
|app_id | a055b383 | Unique application ID assigned by TFL
|app_key | 4cabc676bd56dd4e9025f94aca65c351 | Unique application key assigned by TFL
|a_road_regex | ^([aA0-9_-]){2,5}$ | A Road Naming Validation Regular Expression)
|b_road_regex | ^([bB0-9_-]){4,5}$ | B Road Naming Validation Regular Expression)




# Test

Executable Jar

OR

TflRoadQuery.java run as Java Application

# Author
Eugene Paul Flores

