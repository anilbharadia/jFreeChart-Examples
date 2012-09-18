/**
 * 
 */


import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import org.jfree.chart.plot.MeterPlot;
import org.jfree.data.general.ValueDataset;

/**
 * 
 * Extenstion of {@link MeterPlot} with customization.<br>
 * This class shows tick label for every tick as opossed to <code>MeterPlot</code>
 * 
 * @since Apr 30, 2012 9:47:54 PM
 *
 * @version RCMS 1.0
 *
 * @author <a href="mailto:abharadia@ismnet.com">abharadia</a>
 */
public class CustomMeterPlot extends MeterPlot {

	
	private static final long serialVersionUID = 8619280152355795883L;

	
	public CustomMeterPlot(ValueDataset dataset) {
		super(dataset);
	}

	
	@Override
	protected void drawTick(Graphics2D g2, Rectangle2D meterArea, double value) {
        drawTick(g2, meterArea, value, true);
    }
	
	
}