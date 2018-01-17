<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Lux`s Book shelf</title>
</head>
<body>
<h2>Hello!</h2>
This is the tutorial for how to use my <b>BookShelf</b>.<br>

To start the work with this piece of art you have to find a folder with a name <b>"excelFiles"</b>,<br>
you can find it <b>in a static resources folder of this app</b>.<br>

Just place your <b>.xls</b> or <b>.xlsx</b>file without any russian letters or spaces in the name<br>
and system will parse it and add information to database.<br>
<h3>Make note!</h3> Every book on this bookshelf must be unique!<br>

There are certain functions this BookShelf does:<br>
1. Stores your information from excel files (.xls or .xlsx) in Database.<br>
2. Gives you access to a certain type of data:<br>
To see <b>all authors</b> go to "/authors".<br>
To see <b>all publishers</b> go to "/publishers".<br>
To see <b>all books of certain authors</b> go to "/authors/{authorName}".<br>
To see <b>all books of certain publisher</b> go to "/publishers/{publisherName}".<br>
To see <b>all books</b> go to "/books".<br>

<br>Thank you, and have a nice day ;)<br>
</body>
</html>