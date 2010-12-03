// TreasuryYieldMapper.java
/*
 * Copyright 2010 10gen Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * ... 
 */
package com.mongodb.hadoop.examples;

import java.io.*;
import java.util.*;

import org.apache.commons.logging.*;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;

import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.util.*;
import org.bson.*;

import com.mongodb.hadoop.util.*;

public class TreasuryYieldMapper extends Mapper<java.util.Date, BSONObject, IntWritable, DoubleWritable> {

    private static final Log log = LogFactory.getLog( TreasuryYieldMapper.class );

    public void map( java.util.Date key , BSONObject value , Context context ) throws IOException, InterruptedException{

        int year = key.getYear() + 1900;
        double bid10Year = ((Number) value.get( "bc10Year" )).doubleValue();

        context.write( new IntWritable( year ), new DoubleWritable( bid10Year ) );

    }

}
