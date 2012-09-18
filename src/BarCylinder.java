


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
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
public class BarCylinder extends ApplicationFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4674011044880360221L;

	/**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    public BarCylinder(final String title) {

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
        dataset.setValue(-3, "X", "G");
        
    	
    	
    	return dataset;
    	
    	//dataset.s
    	
        //return dataset;
    }
    

    private JFreeChart createChart(CategoryDataset dataset) {
    	JFreeChart chart = ChartFactory.createBarChart3D("title", "categoryAxisLabel", "valueAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, true);

    	CategoryItemRenderer renderer = new CylinderRenderer();
    	chart.getCategoryPlot().setRenderer(renderer);
    	
        return chart;
        
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final BarCylinder demo = new BarCylinder("Pie Chart Demo 2");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}


