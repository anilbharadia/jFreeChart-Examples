


import java.awt.Color;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
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
public class Bar3DStacked extends ApplicationFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1624093189784576249L;

	/**
     * Default constructor.
     *
     * @param title  the frame title.
     */
    public Bar3DStacked(final String title) {

        super(title);
        final CategoryDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);

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
        dataset.setValue(05, "A", "1");
        dataset.setValue(10, "B", "2");
        dataset.setValue(15, "C", "3");
        dataset.setValue(10, "A", "4");
        dataset.setValue(05, "B", "5");
        dataset.setValue(10, "C", "6");
        dataset.setValue(15, "A", "7");
    	
        dataset.setValue(10, "B", "1");
        dataset.setValue(15, "C", "2");
        dataset.setValue(10, "A", "3");
        dataset.setValue(05, "B", "4");
        dataset.setValue(10, "C", "5");
        dataset.setValue(15, "A", "6");
        dataset.setValue(10, "B", "7");
        
        dataset.setValue(15, "C", "1");
        dataset.setValue(10, "A", "2");
        dataset.setValue(05, "B", "3");
        dataset.setValue(10, "C", "4");
        dataset.setValue(15, "A", "5");
        dataset.setValue(10, "B", "6");
        dataset.setValue(05, "C", "7");
        
    	
        return dataset;
    }
    

    private JFreeChart createChart(CategoryDataset dataset) {
    	JFreeChart chart = ChartFactory.createStackedBarChart3D("Title", "categoryAxisLabel", "valueAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, true);

    	CategoryItemRenderer renderer = chart.getCategoryPlot().getRenderer();
    	renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
    	renderer.setBaseItemLabelsVisible(true);
    	renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BASELINE_CENTER));
    	
    	CategoryPlot plot = chart.getCategoryPlot();
    	
    	ValueAxis rangeAxis = plot.getRangeAxis();
    	
    	CategoryAxis categoryAxis = plot.getDomainAxis();
    	
    	//categoryAxis.setCategoryMargin(0.0005);
    	//categoryAxis.set
    	
    	rangeAxis.setTickLabelPaint(Color.RED);
    	
    	((NumberAxis) rangeAxis).setNumberFormatOverride(NumberFormat.getCurrencyInstance());
    	
    	
    	((BarRenderer3D) renderer).setPositiveItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BASELINE_CENTER));
    	((BarRenderer3D) renderer).setNegativeItemLabelPositionFallback(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BASELINE_CENTER));

    	
        return chart;
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final Bar3DStacked demo = new Bar3DStacked("Pie Chart Demo 2");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}