from flask import Flask, render_template
from pymongo import Connection
from pymongo.objectid import ObjectId

app = Flask(__name__)
app.debug=True

mongo = Connection().bookstore

@app.route("/")
def book_listings(offset=0):
    #books = mongo.books.find().skip(offset * 10).limit(10)
    books = mongo.books.find()
    return render_template('books.html', books=books, offset=offset)

@app.route("/book/<id>")
def view_book(id):
    book = mongo.books.find_one({"_id": ObjectId(id)})
    return render_template("book.html", book=book)

@app.route("/tag/<name>")
def view_tag(name, offset=0):
    books = mongo.books.find({"tags": name})
    return render_template('books.html', books=books, offset=offset)

@app.route("/author/<name>")
def view_author(name, offset=0):
    books = mongo.books.find({"author": name})
    return render_template('books.html', books=books, offset=offset)

if __name__ == "__main__":
    app.run()
