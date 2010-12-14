function m() {
    emit( this._id.getYear(), { count: 1, sum: this.bc10Year })
}

function r( year, values ) {
    var n = { count: 0,  sum: 0 }
    for ( var i = 0; i < values.length; i++ ){ 
        n.sum += values[i].sum;
        n.count += values[i].count;
    }
    
    return n;
}

function f( year, value ){
    value.avg = value.sum / value.count;
    return value.avg;
}

result = db.yield_historical.in.mapReduce( m , r, { finalize: f });