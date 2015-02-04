package net.sf.cotelab.lbl.controller.impl.undoableop;

import net.sf.cotelab.lbl.controller.impl.ControllerImpl;
import net.sf.cotelab.lbl.undo.UndoableOp;

public class DrawOp implements UndoableOp {
	protected int cardIndex;
	protected ControllerImpl controller;
	protected int fanIndex;

	public DrawOp(
			ControllerImpl controller, int fanIndex, int cardIndex) {
		super();
		
		this.controller = controller;
		this.fanIndex = fanIndex;
		this.cardIndex = cardIndex;
	}

	@Override
	public void doOp() {
		controller.draw(fanIndex, cardIndex);
	}

	@Override
	public void undoOp() {
		controller.unDraw(fanIndex, cardIndex);
	}

}