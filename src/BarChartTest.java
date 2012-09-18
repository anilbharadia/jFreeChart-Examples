
import java.awt.Color;
import java.awt.GradientPaint;

import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartTest extends ApplicationFrame {

   public BarChartTest(String title) {
      super(title);
      JPanel chartPanel = createDemoPanel();
      chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
      setContentPane(chartPanel);
   }

   public static DefaultCategoryDataset createDataset() {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset();


      dataset.addValue(10, "Test 1",  "set 1");
      dataset.addValue(30, "Test 2",  "set 1");
      dataset.addValue(40, "Test 3",  "set 1");

      
      return dataset;
   }

   private static JFreeChart createBarChart(
         CategoryDataset dataset) {

      CategoryAxis categoryAxis = new CategoryAxis("");
      ValueAxis valueAxis = new NumberAxis("");

      StandardBarPainter painter = new StandardBarPainter();

      BarRenderer.setDefaultBarPainter(painter);
      BarRenderer renderer = new BarRenderer();

      // tooltips
      renderer.setShadowVisible(false);
      renderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());

      Color primaryColor = Color.red;
      Color secondaryColor = Color.blue;

      GradientPaint gpVertical = new GradientPaint(5, 5, primaryColor, 10, 5,
            secondaryColor, true);

      GradientPaint gpHorizontal = new GradientPaint(5, 5, primaryColor, 5,
            10, secondaryColor, true);

      GradientPaint gpUpSlant = new GradientPaint(5, 5, primaryColor, 10, 10,
            secondaryColor, true);

      renderer.setSeriesPaint(0, gpVertical);
      renderer.setSeriesPaint(1, gpHorizontal);
      renderer.setSeriesPaint(2, gpUpSlant);

      CategoryPlot plot = new CategoryPlot(dataset, categoryAxis, valueAxis,
            renderer);
      plot.setOrientation(PlotOrientation.VERTICAL);

      JFreeChart chart = new JFreeChart(plot);

      return chart;

   }

   public static JPanel createDemoPanel() {
      JFreeChart chart = createBarChart(createDataset());
      ChartPanel chartPanel = new ChartPanel(chart);
      chartPanel.setPopupMenu(null);

      chartPanel.setDomainZoomable(true);
      chartPanel.setRangeZoomable(true);
      return chartPanel;
   }

   public static void main(String[] args) {
      BarChartTest demo = new BarChartTest("BarChart gradient test");
      demo.pack();
      RefineryUtilities.centerFrameOnScreen(demo);
      demo.setVisible(true);
   }

}