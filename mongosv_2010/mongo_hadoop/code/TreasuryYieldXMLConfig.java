// TreasuryYieldXMLConfig.java
/*
 * Copyright 2010 10gen Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * ... 
 */
package com.mongodb.hadoop.examples;

import java.io.*;
import java.util.*;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.util.*;
import org.bson.*;

import com.mongodb.hadoop.util.*;

public class TreasuryYieldXMLConfig extends MongoTool {

    static {
        // Load the XML config defined in hadoop-local.xml
        Configuration.addDefaultResource( "src/examples/hadoop-local.xml" );
        Configuration.addDefaultResource( "src/examples/mongo-defaults.xml" );
    }

    public static void main( String[] args ) throws Exception{
        final int exitCode = ToolRunner.run( new TreasuryYieldXMLConfig(), args );
        System.exit( exitCode );
    }
}
