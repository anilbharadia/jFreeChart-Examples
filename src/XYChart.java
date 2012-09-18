


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a pie chart using data from a
 * {@link DefaultPieDataset}.  This demo also shows an "exploded" section in the chart.
 *
 */
public class XYChart extends ApplicationFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3114198779331053753L;

	/**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    public XYChart(final String title) {

        super(title);
        final JFreeChart chart = createChart(createDataset());

        // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        setContentPane(chartPanel);

    }

    /**
     * Creates a sample dataset.
     * 
     * @return a sample dataset.
     */
    private XYSeriesCollection createDataset() {
    	XYSeriesCollection collection = new XYSeriesCollection();
        
    	XYSeries s1 = new XYSeries("S1");
    	s1.add(1, 5);
    	s1.add(2, 9);
    	s1.add(3, 3);
    	s1.add(4, 8);
    	collection.addSeries(s1);
    	
    	
    	XYSeries s2 = new XYSeries("S2");
    	s2.add(1, 9);
    	s2.add(2, 3);
    	s2.add(3, 8);
    	s2.add(4, 5);
    	collection.addSeries(s2);
    	
    	
    	XYSeries s3 = new XYSeries("S3");
    	for (double i =0; i<4; i += 0.1) {
    		s3.add(i, Math.sin(i));
    	}
    	collection.addSeries(s3);
    	
    	return collection;
    	
    	//dataset.s
    	
        //return dataset;
    }
    

    private JFreeChart createChart(XYSeriesCollection dataset) {
    	JFreeChart chart = ChartFactory.createXYLineChart("title", "xAxisLabel", "yAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, true);

    	//chart.getXYPlot().addAnnotation(new XYPointerAnnotation("label", 2, 2, 90));
    	
    	//chart.getXYPlot().setRenderer(new XYLineAndShapeRenderer());
    	
        return chart;
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final XYChart demo = new XYChart("Pie Chart Demo 2");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}