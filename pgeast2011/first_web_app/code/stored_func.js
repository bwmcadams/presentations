// START: CreateStoredCheckFunc
> var _checkTime = function(date, hour, minuteStart, minuteEnd) {
...     var hourOk = date.getHours() == hour;
...     var minuteOk = true; 
...     if (minuteStart != null && minuteEnd != null)
...         minuteOk = date.getMinutes() >= minuteStart && 
...                    date.getMinutes() <= minuteEnd;
...     else if (minuteStart != null) 
...         minuteOk = date.getMinutes() == minuteStart;   
...     return hourOk && minuteOk;
... } 
> var test = new Date("Mon Aug 16 2010 14:25:11 GMT-0400 (EDT)")
> test
"Mon Aug 16 2010 14:25:11 GMT-0400 (EDT)"
> _checkTime(test, 9)
false
> _checkTime(test, 14)
true
> _checkTime(test, 14, 25)
true
> _checkTime(test, 14, 15, 45)
true
> db.system.js.insert({_id: "checkTime", value: _checkTime})
> db.system.js.find({_id: "checkTime"})
{ "_id" : "checkTime", 
  "value" : function cf__1__f_(date, hour, minuteStart, minuteEnd) {
    var hourOk = date.getHours() == hour;
    var minuteOk = true;
    if (minuteStart != null && minuteEnd != null) {
        minuteOk = date.getMinutes() >= minuteStart &&
            date.getMinutes() <= minuteEnd;
    } else if (minuteStart != null) {
        minuteOk = date.getMinutes() == minuteStart;
    }
    return hourOk && minuteOk;
} }



> db.orders.find({date: 
...   {$gte: midnight, $lt: tomorrow},
...   $where: function() {
...      return checkTime(this.date, 14, 0, 30);
...   }})
{
        "_id" : ObjectId("4c69f7ed94e047532497d174"),
        "product" : {
                "book" : "JavaScript: The Good Parts",
                "author" : "Douglas Crockford"
        },
        "quantity" : 1,
        "price" : {
                "currency" : "USD",
                "msrp": 29.99,
                "amount" : 19.99,
                "tax": 1.77,
                "shipping": 3.99,
                "total": 25.75
        },
        "date" : "Mon Aug 16 2010 14:25:11 GMT-0400 (EDT)"
}

