<?xml version="1.0" encoding="UTF-8" ?>

<hadoopjob version="0.20.2">
  <bootstrap input="/Users/mac/develop/tmp/mr/homework/HomeworkTemplate/data/input.txt" filesystem="00000000-0000-0000-377a-99710000002f"/>
  <configuration>
    <entry key="MAPREDUCE_JOB_MAPS" type="java.lang.Integer" value="3"/>
    <entry key="KARMASPHERE_MAPREDUCE_REDUCE_DETECT_TYPES" type="java.lang.Boolean" value="True"/>
    <entry key="MAPREDUCE_REDUCE_NEWAPI" type="java.lang.Boolean" value="True"/>
    <entry key="KARMASPHERE_MAPREDUCE_MAP_DETECT_TYPES" type="java.lang.Boolean" value="True"/>
    <entry key="MAPREDUCE_JOB_OUTPUT_KEY_CLASS" type="com.karmasphere.studio.common.lang.ClassDescriptor" value="org.apache.hadoop.io.Text"/>
    <entry key="MAPREDUCE_JOB_OUTPUT_VALUE_CLASS" type="com.karmasphere.studio.common.lang.ClassDescriptor" value="org.apache.hadoop.io.Text"/>
    <entry key="MAPREDUCE_MAP_OUTPUT_VALUE_CLASS" type="com.karmasphere.studio.common.lang.ClassDescriptor" value="org.apache.hadoop.io.Text"/>
    <entry key="MAPREDUCE_JOB_REDUCES" type="java.lang.Integer" value="2"/>
    <entry key="MAPREDUCE_MAP_OUTPUT_KEY_CLASS" type="com.karmasphere.studio.common.lang.ClassDescriptor" value="org.apache.hadoop.io.Text"/>
    <entry key="MAPREDUCE_MAP_NEWAPI" type="java.lang.Boolean" value="True"/>
    <entry name="" type="java.lang.String" value=""/>
  </configuration>
  <operation type="input">
    <operator qualifiedName="org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat" binaryName="org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat"/>
  </operation>
  <operation type="mapper">
    <operator qualifiedName="org.smaple.HomeworkMapper" binaryName="org.smaple.HomeworkMapper"/>
  </operation>
  <operation type="partitioner">
    <operator qualifiedName="org.apache.hadoop.mapreduce.lib.partition.HashPartitioner" binaryName="org.apache.hadoop.mapreduce.lib.partition.HashPartitioner"/>
  </operation>
  <operation type="comparator">
  </operation>
  <operation type="combiner">
  </operation>
  <operation type="reducer">
    <operator qualifiedName="org.smaple.HomeworkReducer" binaryName="org.smaple.HomeworkReducer"/>
  </operation>
  <operation type="outputformat">
    <operator qualifiedName="org.apache.hadoop.mapreduce.lib.output.TextOutputFormat" binaryName="org.apache.hadoop.mapreduce.lib.output.TextOutputFormat"/>
  </operation>
  <defaultArgs>
  </defaultArgs>
  <uploadedFiles>
  </uploadedFiles>
</hadoopjob>
