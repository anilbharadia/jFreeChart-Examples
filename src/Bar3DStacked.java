


import java.awt.Color;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.TickUnitSource;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StackedBarRenderer3D;
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
        
    	dataset.setValue(05, "[0-30]",    "BCBS");
    	dataset.setValue(10, "[31-60]",   "BCBS");
    	dataset.setValue(15, "[61-90]",   "BCBS");
    	dataset.setValue(10, "[91-120]",  "BCBS");
        dataset.setValue(05, "[121-150]", "BCBS");
        dataset.setValue(10, "[151-180]", "BCBS");
    	
        dataset.setValue(05, "[0-30]",    "Champus");
    	dataset.setValue(10, "[31-60]",   "Champus");
    	dataset.setValue(15, "[61-90]",   "Champus");
    	dataset.setValue(10, "[91-120]",  "Champus");
        dataset.setValue(05, "[121-150]", "Champus");
        dataset.setValue(10, "[151-180]", "Champus");
        
        dataset.setValue(05, "[0-30]",    "Commercial");
    	dataset.setValue(10, "[31-60]",   "Commercial");
    	dataset.setValue(15, "[61-90]",   "Commercial");
    	dataset.setValue(10, "[91-120]",  "Commercial");
        dataset.setValue(05, "[121-150]", "Commercial");
        dataset.setValue(10, "[151-180]", "Commercial");
        
        dataset.setValue(05, "[0-30]",    "Medicare");
    	dataset.setValue(10, "[31-60]",   "Medicare");
    	dataset.setValue(15, "[61-90]",   "Medicare");
    	dataset.setValue(10, "[91-120]",  "Medicare");
        dataset.setValue(05, "[121-150]", "Medicare");
        dataset.setValue(10, "[151-180]", "Medicare");
        
        dataset.setValue(05, "[0-30]",    "Medicaid");
    	dataset.setValue(10, "[31-60]",   "Medicaid");
    	dataset.setValue(15, "[61-90]",   "Medicaid");
    	dataset.setValue(10, "[91-120]",  "Medicaid");
        dataset.setValue(05, "[121-150]", "Medicaid");
        dataset.setValue(10, "[151-180]", "Medicaid");
        
        dataset.setValue(05, "[0-30]",    "Others");
    	dataset.setValue(10, "[31-60]",   "Others");
    	dataset.setValue(15, "[61-90]",   "Others");
    	dataset.setValue(10, "[91-120]",  "Others");
        dataset.setValue(05, "[121-150]", "Others");
        dataset.setValue(10, "[151-180]", "Others");
        
        
    	
        return dataset;
    }
    

    private JFreeChart createChart(CategoryDataset dataset) {
    	JFreeChart chart = ChartFactory.createStackedBarChart3D("Title", "categoryAxisLabel", "valueAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, true);

    	CategoryItemRenderer renderer = chart.getCategoryPlot().getRenderer();
    	
    	
    	renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
    	/*
    	renderer.setBaseItemLabelGenerator(new CategoryItemLabelGenerator() {
			
			@Override
			public String generateRowLabel(CategoryDataset arg0, int arg1) {
				return "ROW-" + arg1;
			}
			
			@Override
			public String generateLabel(CategoryDataset arg0, int arg1, int arg2) {
				return "LABEL-" + arg1 + "-" + arg2;
			}
			
			@Override
			public String generateColumnLabel(CategoryDataset arg0, int arg1) {
				return "COL-" + arg1;
			}
		});*/
    	
    	
    	renderer.setBaseItemLabelsVisible(true);
    	renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BASELINE_CENTER));
    	
    	CategoryPlot plot = chart.getCategoryPlot();
    	
    	ValueAxis rangeAxis = plot.getRangeAxis();
    	
    	CategoryAxis categoryAxis = plot.getDomainAxis();
    	
    	rangeAxis.setTickLabelPaint(Color.RED);
    	
    	((NumberAxis) rangeAxis).setNumberFormatOverride(NumberFormat.getCurrencyInstance());
    	
    	
    	//((StackedBarRenderer3D) renderer).set
    	
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