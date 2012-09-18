


import java.awt.Color;
import java.awt.Paint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.AbstractRenderer;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

/**
 * A simple demonstration application showing how to create a pie chart using data from a
 * {@link DefaultPieDataset}.  This demo also shows an "exploded" section in the chart.
 *
 */
public class Bar3D extends ApplicationFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1314877738034042129L;

	/**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    public Bar3D(final String title) {

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

    	JFreeChart chart = ChartFactory.createBarChart3D("OUTSIDE12", "categoryAxisLabel", "valueAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, true);

    	CategoryItemRenderer renderer = new CustomBarRenderer3D();
    	chart.getCategoryPlot().setRenderer(renderer);
    	
    	renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
    	renderer.setBaseItemLabelsVisible(true);
    	renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
    	//((AbstractRenderer) renderer).set
    	
        return chart;
        
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final Bar3D demo = new Bar3D("Pie Chart Demo 2");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}


class CustomBarRenderer3D extends BarRenderer3D {

	private static final long serialVersionUID = 5666702838603763643L;
	
	private Paint[] colors;

	public CustomBarRenderer3D() {
		this.colors = new Paint[] {
			Color.red, 
			Color.blue, 
			Color.green, 
			Color.yellow, 
			Color.orange, 
			Color.cyan, 
			Color.magenta, 
			Color.blue
		}; 
	}

	public Paint getItemPaint(final int row, final int column) {
	    // returns color for each column
		return (this.colors[column % this.colors.length]);
	}
	 
	 
}