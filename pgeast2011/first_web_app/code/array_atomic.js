> db.inventory.update({"title": "The Hitchhiker's Guide to the Galaxy"},
... {"$push": {"tags": {"tag": "exploding whales", "weight": .25}}})      
> db.inventory.findOne({"title": "The Hitchhiker's Guide to the Galaxy"})                                                
{
	"_id" : ObjectId("4c868434cad498145f000001"),
	"author" : "Douglas Adams",
	"isbn" : "0345391803",
	"price" : {
		"msrp" : 15,
		"discount" : 10
	},
	"publicationYear" : 1995,
	"publisher" : "The Ballantine Publishing Group",
	"quantity" : 150,
	"tags" : [
		{
			"tag" : "science fiction",
			"weight" : 0.75
		},
		{
			"tag" : "comedy",
			"weight" : 0.75
		},
		{
			"tag" : "humor",
			"weight" : 0.75
		},
		{
			"tag" : "snarky",
			"weight" : 0.7
		},
		{
			"tag" : "towels",
			"weight" : 0.5
		},
		{
			"tag" : "exploding whales",
			"weight" : 0.25
		}
	],
	"title" : "The Hitchhiker's Guide to the Galaxy"
}


> db.inventory.update({"title": "The Hitchhiker's Guide to the Galaxy"},
... {"$pull": {"tags": {"tag": "exploding whales"}}})
> db.inventory.findOne({"title": "The Hitchhiker's Guide to the Galaxy"})                                                
{
	"_id" : ObjectId("4c868434cad498145f000001"),
	"author" : "Douglas Adams",
	"isbn" : "0345391803",
	"price" : {
		"msrp" : 15,
		"discount" : 10
	},
	"publicationYear" : 1995,
	"publisher" : "The Ballantine Publishing Group",
	"quantity" : 150,
	"tags" : [
		{
			"tag" : "science fiction",
			"weight" : 0.75
		},
		{
			"tag" : "comedy",
			"weight" : 0.75
		},
		{
			"tag" : "humor",
			"weight" : 0.75
		},
		{
			"tag" : "snarky",
			"weight" : 0.7
		},
		{
			"tag" : "towels",
			"weight" : 0.5
		}
	],
	"title" : "The Hitchhiker's Guide to the Galaxy"
}


> db.inventory.update({"title": "The Hitchhiker's Guide to the Galaxy"},
... {"$addToSet": {"tags": {"tag": "humor", "weight": .75}}})
> db.inventory.update({"title": "The Hitchhiker's Guide to the Galaxy"},
... {"$addToSet": {"tags": {"tag": "humor", "weight": .75}}})
> db.inventory.update({"title": "The Hitchhiker's Guide to the Galaxy"},
... {"$addToSet": {"tags": {"tag": "humor", "weight": .75}}})
> db.inventory.findOne({"title": "The Hitchhiker's Guide to the Galaxy"})                                                
{
	"_id" : ObjectId("4c868434cad498145f000001"),
	"author" : "Douglas Adams",
	"isbn" : "0345391803",
	"price" : {
		"msrp" : 15,
		"discount" : 10
	},
	"publicationYear" : 1995,
	"publisher" : "The Ballantine Publishing Group",
	"quantity" : 150,
	"tags" : [
		{
			"tag" : "science fiction",
			"weight" : 0.75
		},
		{
			"tag" : "comedy",
			"weight" : 0.75
		},
		{
			"tag" : "humor",
			"weight" : 0.75
		},
		{
			"tag" : "snarky",
			"weight" : 0.7
		},
		{
			"tag" : "towels",
			"weight" : 0.5
		},
		{
			"tag" : "humor",
			"weight" : 0.75
		}
	],
	"title" : "The Hitchhiker's Guide to the Galaxy"
}
