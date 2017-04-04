import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MaxTemperatureReducer
  extends Reducer<Text, IntWritable, Text, Text> {
	String temp = null;
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
    
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (IntWritable value : values) {
      max = Math.max(max, value.get());
      min = Math.min(min, value.get());
      String max2, min2;
      max2 = Integer.toString(maxValue);
      min2 = Integer.toString(minValue);
      temp = max2 + " " + min2;
      
    }
    context.write(key, new Text(temp));
  }
}
