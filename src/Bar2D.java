


import java.awt.Color;
import java.awt.GradientPaint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A simple demonstration application showing how to create a pie chart using data from a
 * {@link DefaultPieDataset}.  This demo also shows an "exploded" section in the chart.
 *
 */
public class Bar2D extends ApplicationFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1314877738034042129L;

	/**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    public Bar2D(final String title) {

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
    private CategoryDataset createDataset() {
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(10, "X", "A");
        dataset.setValue(8,  "X", "B");
        dataset.setValue(6,  "X", "C");
        dataset.setValue(12, "X", "D");
        dataset.setValue(9,  "X", "E");
        dataset.setValue(11, "X", "F");
        dataset.setValue(3,  "X", "G");
        
    	
    	
    	return dataset;
    	
    	//dataset.s
    	
        //return dataset;
    }
    

    private JFreeChart createChart(CategoryDataset dataset) {
    	//JFreeChart chart = ChartFactory.createXYLineChart("title", "xAxisLabel", "yAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, true);

    	JFreeChart chart = ChartFactory.createBarChart("title", "categoryAxisLabel", "valueAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, true);

    	CategoryPlot plot = chart.getCategoryPlot();
    	
    	//plot.setRangeCrosshairPaint(Color.RED);
    	//plot.setDomainGridlinePaint(Color.RED);
    	
    	plot.setRangeGridlinePaint(Color.BLACK);
    
    	plot.setBackgroundPaint(Color.WHITE);
    	
    	plot.setOutlineVisible(false);
    	
    	BarRenderer renderer = (BarRenderer) plot.getRenderer();
    	
    	renderer.setGradientPaintTransformer(null);
    	
    	
    	GradientPaint gp1 = new GradientPaint(
			7, 7, Color.BLUE,
			2, 2, Color.BLACK,
			true
		);
		renderer.setSeriesPaint(0, gp1);
    	
		
		
		
    	//renderer.setSeriesFillPaint(0, gp1);
    	
    	renderer.setBarPainter(new StandardBarPainter());
    	
		//plot.setRangeGridlinePaint(gp1);
    	
    	
    	/*Point2D start = new Point2D.Float(10, 5);
        Point2D end = new Point2D.Float(5, 10);
        float[] dist = {0.2f, 0.4f, 0.6f};
        Color[] colors = {Color.RED, Color.YELLOW, Color.RED};
        LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
        renderer.setSeriesPaint(0, p);*/
        
        
    	
    	//chart.getXYPlot().setDomainGridlinePaint(Color.RED);
    	
        return chart;
        
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final Bar2D demo = new Bar2D("Pie Chart Demo 2");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}


