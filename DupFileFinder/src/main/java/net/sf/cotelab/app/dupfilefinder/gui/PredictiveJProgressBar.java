/**
 * 
 */
package net.sf.cotelab.app.dupfilefinder.gui;

import java.util.Date;

import javax.swing.BoundedRangeModel;
import javax.swing.JProgressBar;

/**
 * @author TEST
 *
 */
public class PredictiveJProgressBar extends ResettableJProgressBar {
	protected Date epoch = new Date();

	/**
	 * 
	 */
	public PredictiveJProgressBar() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orient
	 */
	public PredictiveJProgressBar(int orient) {
		super(orient);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param newModel
	 */
	public PredictiveJProgressBar(BoundedRangeModel newModel) {
		super(newModel);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param min
	 * @param max
	 */
	public PredictiveJProgressBar(int min, int max) {
		super(min, max);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param orient
	 * @param min
	 * @param max
	 */
	public PredictiveJProgressBar(int orient, int min, int max) {
		super(orient, min, max);
		// TODO Auto-generated constructor stub
	}

	public Date getEpoch() {
		return epoch;
	}

	public void setEpoch(Date epoch) {
		this.epoch = epoch;
		
		setValue(0);	// no progress if we're just now starting
	}

	@Override
	public void setValue(int n) {
		// TODO Auto-generated method stub
		super.setValue(n);
		
		updateString();
	}
	
	protected void updateString() {
		if (!isIndeterminate() && (epoch != null)) {
			long epochMillis = epoch.getTime();
			long nowMillis = (new Date()).getTime();
			long elapsedMillis = nowMillis - epochMillis;
			double minValue = this.getMinimum();
			double value = this.getValue();
			double maxValue = this.getMaximum();
			double valueRange = maxValue - minValue;
			
			if (valueRange > 0) {
				double valueFraction = (value - minValue) / valueRange;
				long predictedTotalMillis = (long) (elapsedMillis / valueFraction);
				long predictedRemainingMillis = predictedTotalMillis - elapsedMillis;
				double dblPctComplete = 100 * valueFraction;
				int pctComplete = (int) (dblPctComplete + 0.5);
				// format the time remaining
				String timeRemainingString = formatElapsedTime(predictedRemainingMillis);
				String pctCompleteString = Integer.toString(pctComplete);
				String message = pctCompleteString + "% (" + timeRemainingString + " remaining)";
				
				setString(message);
			}
		}
	}
	
	public String formatElapsedTime(long totalMillis) {
		long millisPart = totalMillis % 1000;
		long secsRmn = totalMillis / 1000;
		long secsPart = secsRmn % 60;
		long minsRmn = secsRmn / 60;
		long minsPart = minsRmn % 60;
		long hrsRmn = minsRmn / 60;
		long hrsPart = hrsRmn % 24;
		long daysRmn = hrsRmn / 24;
		String millisString = Long.toString(millisPart);
		String secsString = Long.toString(secsPart);
		String minsString = Long.toString(minsPart);
		String hrsString = Long.toString(hrsPart);
		String daysString = Long.toString(daysRmn);
		String message = daysString + "d " + hrsString + "h " +
						minsString + "m " + secsString + "." +
				millisString + "s";
		
		return message;
	}

	@Override
	public void setModel(BoundedRangeModel newModel) {
		// TODO Auto-generated method stub
		super.setModel(newModel);
		
		updateString();
	}

	@Override
	public void setMinimum(int n) {
		// TODO Auto-generated method stub
		super.setMinimum(n);
		
		updateString();
	}

	@Override
	public void setMaximum(int n) {
		// TODO Auto-generated method stub
		super.setMaximum(n);
		
		updateString();
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		super.reset();
		
		setEpoch(new Date());
	}
}
