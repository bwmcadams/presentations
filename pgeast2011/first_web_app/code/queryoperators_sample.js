> db.inventory.find({"price.discount": {$lt: 35, $gt: 25}}, {"title": 1, "author": 1}).limit(2)
{ "_id" : ObjectId("4d59b6aecad4987053000173"), "author" : "Benjamin C. Pierce", "title" : "Basic Category Theory For Computer Scientists" }
{ "_id" : ObjectId("4d59b43acad498705300002b"), "author" : "{Brooks, Jr.}, Frederick P.", "title" : "The Mythical Man Month: Essays on Software Engineering" }

> db.inventory.find({"publisher": {$in: ["O'Reilly & Associates, Inc", "The Pragmatic Programmers, LLC"]}}, {"title": 1, "author": 1, "publisher": 1})
{ "_id" : ObjectId("4d59b6a0cad498705300016b"), "author" : "Terence Parr", "publisher" : "The Pragmatic Programmers, LLC", "title" : "The Definitive ANTLR Reference: Building Domain-Specific Languages" }
{ "_id" : ObjectId("4d59b468cad4987053000046"), "author" : "Mike Clark", "publisher" : "The Pragmatic Programmers, LLC", "title" : "Advanced Rails Recipes: 84 New Ways to Build Stunning Rails Apps" }
{ "_id" : ObjectId("4d59b686cad498705300015e"), "author" : "Michael T. Nygard", "publisher" : "The Pragmatic Programmers, LLC", "title" : "Release It!: Design and Deploy Production-Ready Software" }
{ "_id" : ObjectId("4d59b72ccad49870530001af"), "author" : "Rachel Sedley and Liz Davies", "publisher" : "The Pragmatic Programmers, LLC", "title" : "Agile Coaching" }
{ "_id" : ObjectId("4d59b6efcad4987053000190"), "author" : "Leonard Richardson and Sam Ruby", "publisher" : "O'Reilly & Associates, Inc", "title" : "RESTful Web Services" }
{ "_id" : ObjectId("4d59b757cad49870530001c4"), "author" : "Sonatype Company", "publisher" : "O'Reilly & Associates, Inc", "title" : "Maven: The Definitive Guide" }



