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

public class TreasuryYieldReducer extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {

    private static final Log log = LogFactory.getLog( TreasuryYieldReducer.class );

    public void reduce( IntWritable key , Iterable<DoubleWritable> values , Context context ) throws IOException, InterruptedException{

        int count = 0;
        double sum = 0;
        for ( final DoubleWritable value : values ) {
            log.debug( "Key: " + key + " Value: " + value );
            sum += value.get();
            count++;
        }

        double avg = sum / count;

        log.info( "Average 10 Year Treasury for " + key.get() + " was " + avg );

        context.write( key, new DoubleWritable( avg ) );
    }

}
