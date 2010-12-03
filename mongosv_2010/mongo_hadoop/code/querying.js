> db.yield_historical.in.findOne({"bc5Year": 8.43})
{
        "_id" : "Mon Jan 29 1990 19:00:00 GMT-0500 (EST)",
        "dayOfWeek" : "TUESDAY",
        "bc3Year" : 8.39,
        "bc5Year" : 8.43,
        "bc10Year" : 8.51,
        "bc20Year" : null,
        "bc1Month" : null,
        "bc2Year" : 8.3,
        "bc3Month" : 8,
        "bc30Year" : 8.55,
        "bc1Year" : 8.09,
        "bc7Year" : 8.47,
        "bc6Month" : 8.14
}

> db.yield_historical.in.find({"_id": {"$gt": new Date(2010, 8, 27)}})
{ "_id" : "Mon Sep 27 2010 20:00:00 GMT-0400 (EDT)", "dayOfWeek" : "TUESDAY  ", "bc3Year" : 0.64, "bc5Year" : 1.25, "bc10Year" : 2.48, "bc20Year" : 3.35, "bc1Month" : 0.08, "bc2Year" : 0.37, "bc3Month" : 0.16, "bc30Year" : 3.66, "bc1Year" : 0.26, "bc7Year" : 1.85, "bc6Month" : 0.2 }
{ "_id" : "Tue Sep 28 2010 20:00:00 GMT-0400 (EDT)", "dayOfWeek" : "WEDNESDAY", "bc3Year" : 0.67, "bc5Year" : 1.28, "bc10Year" : 2.52, "bc20Year" : 3.38, "bc1Month" : 0.12, "bc2Year" : 0.44, "bc3Month" : 0.16, "bc30Year" : 3.69, "bc1Year" : 0.27, "bc7Year" : 1.9100000000000001, "bc6Month" : 0.2 }
{ "_id" : "Wed Sep 29 2010 20:00:00 GMT-0400 (EDT)", "dayOfWeek" : "THURSDAY ", "bc3Year" : 0.64, "bc5Year" : 1.27, "bc10Year" : 2.5300000000000002, "bc20Year" : 3.38, "bc1Month" : 0.14, "bc2Year" : 0.42, "bc3Month" : 0.16, "bc30Year" : 3.69, "bc1Year" : 0.27, "bc7Year" : 1.9100000000000001, "bc6Month" : 0.19 }
               
> db.yield_historical.in.distinct("dayOfWeek")
[
        "FRIDAY",
        "FRIDAY   ",
        "MONDAY",
        "MONDAY   ",
        "THURSDAY",
        "THURSDAY ",
        "TUESDAY",
        "TUESDAY  ",
        "WEDNESDAY"
]