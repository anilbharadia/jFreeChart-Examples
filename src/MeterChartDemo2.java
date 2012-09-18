

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.DialShape;
import org.jfree.chart.plot.MeterInterval;
import org.jfree.data.Range;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.data.general.ValueDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
* A simple demonstration application showing how to create a meter chart.
*/
public class MeterChartDemo2 extends ApplicationFrame {

    private static DefaultValueDataset dataset;
   
    /**
     * Creates a new demo.
     *
     * @param title  the frame title.
     */
    public MeterChartDemo2(String title) {
        super(title);
        JPanel chartPanel = createDemoPanel();
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }
   
    /**
     * Creates a sample chart.
     *
     * @param dataset  a dataset.
     *
     * @return The chart.
     */
    private static JFreeChart createChart(ValueDataset dataset) {
    	CustomMeterPlot plot = new CustomMeterPlot(dataset);
        
        plot.addInterval(new MeterInterval("All", new Range(0.0, 100.0)));
        
        plot.addInterval(new MeterInterval("High", new Range(80.0, 100.0)));
        plot.setDialOutlinePaint(Color.white);
        
        plot.addInterval(new MeterInterval("Low", new Range(0.00, 20.0), Color.RED, new BasicStroke(2.0f), null));
        //plot.addInterval(new MeterInterval("Low", new Range(100.00, 250.0), Color.GREEN, new BasicStroke(2.0f), null));
        
        //plot.addInterval(new MeterInterval("CS", new Range(48.68, 65.48), Color.RED, new BasicStroke(2.0f), null));
        
        plot.setUnits("Days");
        plot.setTickLabelsVisible(true);
        plot.setDialShape(DialShape.CHORD);
        
        plot.setValuePaint(Color.BLUE);
        
        //plot.getIntervals().a
        
        plot.setTickLabelsVisible(true);
        
        plot.setRange(new Range(0, 100));
        
        //plot.setMeterAngle(180);
        
        //plot.
        
        plot.setTickLabelPaint(Color.ORANGE);
        
        JFreeChart chart = new JFreeChart("Meter Chart 2", JFreeChart.DEFAULT_TITLE_FONT, plot, false);
        return chart;
    }
   
    /**
     * Creates a panel for the demo (used by SuperDemo.java).
     *
     * @return A panel.
     */
    public static JPanel createDemoPanel() {
        dataset = new DefaultValueDataset(50.0);
        JFreeChart chart = createChart(dataset);
        JPanel panel = new JPanel(new BorderLayout());
        JSlider slider = new JSlider(0, 100, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider s = (JSlider) e.getSource();
                dataset.setValue(new Integer(s.getValue()));
            }
        });
        panel.add(new ChartPanel(chart));
        panel.add(BorderLayout.SOUTH, slider);
        return panel;
    }
   
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(String[] args) {
        MeterChartDemo2 demo = new MeterChartDemo2("Meter Chart Demo 2");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
    
    
    

}

