# Java project on restarant Mangement

## How to run this program on local machine
- Clone this repository <br>

### Import database
- Open MySQL workbench.
- Connect to your MySQL database.
- Click ***Server*** on the main tool bar.
- Select ***Data Import***.
- Select ***import from self contained*** file.
- Click the ***...*** and navigate to where your MySQL backup file is located , select the backup you want to load ( *restaurantdatabase.sql* in database *description description* folder of project), and click OK.
- The dump file contain the schema so left ***Default Target Schema*** <mark>untouched</mark>.
- Select Start Import on the bottom right.

### Running
 - Open the project in VS Code
 - Run the App.java
 <br> or
 - Open the project location in command line
 - run bin/App using command `java bin/App`
 <br>
 
## What it does
This is a java project for restaurant management <br>

## You can log in as cusomter or owner 

## As owner you can
- See menu
- See all customers
- Add customers
## As customer you can
- See menu
- Select food items and their quantity
- Pay bill
 

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `bin`: the folder to main .class files
- `database description`: the folder to database dump file

