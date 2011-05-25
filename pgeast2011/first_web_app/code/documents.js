> db.inventory.findOne({"title": /^The Prag/})
{
	"_id" : ObjectId("4d59b5a6cad49870530000ec"),
	"author" : "Andrew Hunt and David Thomas",
	"isbn" : "020161622X",
	"price" : {
		"discount" : 35.28,
		"msrp" : 49.99
	},
	"publicationYear" : 2000,
	"publisher" : "Addison-Wesley",
	"quantity" : NumberLong(50),
	"tags" : [
		"programming",
		"software development",
		"agile development",
		"best practices",
		"computer science"
	],
	"title" : "The Pragmatic Programmer: From Journeyman to Master"
}

