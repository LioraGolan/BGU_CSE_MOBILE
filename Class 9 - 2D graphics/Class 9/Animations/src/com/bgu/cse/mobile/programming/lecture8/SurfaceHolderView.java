package com.bgu.cse.mobile.programming.lecture8;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SurfaceHolderView extends SurfaceView implements SurfaceHolder.Callback{
	private SurfaceHolder surfaceHolder;
	private DrawingThread drawingThread;
	private int dy;
	private int dx;
	protected enum HorizontalDirection {LEFT, RIGHT}
	protected enum VerticalDirection {UP, DOWN}
	private final int SLOW = 5;
	private final int FAST = 20;
	private final int SMALL = 30;
	private final int BIG = 70;
	private int size;

	public SurfaceHolderView(Context context) {
		super(context);
		surfaceHolder = getHolder();
		surfaceHolder.addCallback(this);
		dy = SLOW;
		dx = SLOW;
		size = SMALL;
	}
	
	/*
	 * SurfaceHolder callbacks
	 */
	
	//////////
	public void surfaceCreated(SurfaceHolder holder) {
		drawingThread = new DrawingThread(surfaceHolder, this.getWidth(),this.getHeight());
		drawingThread.start();
	}
	public void surfaceDestroyed(SurfaceHolder holder) {
		drawingThread.waitForExit();
		drawingThread = null;
	}
	public void surfaceChanged(SurfaceHolder holder,
			int format, int w, int h) {
		drawingThread.onWindowResize(w, h);
	}
	//////////
	
	public class DrawingThread extends Thread{
		protected Drawable ball;
		protected Point ballPos = new Point(0,0);
		protected HorizontalDirection myXDirection = HorizontalDirection.RIGHT;
		protected VerticalDirection myYDirection = VerticalDirection.UP;

		private boolean stop = false;
		private SurfaceHolder surfaceHolder;
		
		private int width;
		private int hight;
		
		public DrawingThread(SurfaceHolder sh,int w, int h) {			
			surfaceHolder = sh;
			this.ball =	getResources().getDrawable(R.drawable.ball);
		}
		
		@Override
		public void run() {
			while (!stop) {
				Canvas canvas = surfaceHolder.lockCanvas(null);
				canvas.drawColor(0xFFFFFAA5);
				drawToCanvas(canvas);
				surfaceHolder.unlockCanvasAndPost(canvas);
			}

		}
		
		private void drawToCanvas(Canvas canvas){
			this.ball.setBounds(this.ballPos.x,
					this.ballPos.y,
					this.ballPos.x + size, 
					this.ballPos.y + size);

			// decide to which direction to go
			if (ballPos.x >= width - this.ball.getBounds().width()) {
				this.myXDirection = HorizontalDirection.LEFT;
			} else if (ballPos.x <= 0) {
				this.myXDirection = HorizontalDirection.RIGHT;
			}
			if (ballPos.y >= (hight - this.ball.getBounds().height())) {
				this.myYDirection = VerticalDirection.UP;
			} else if (ballPos.y <= 0) {
				this.myYDirection = VerticalDirection.DOWN;
			}

			// reposition
			if (this.myXDirection == HorizontalDirection.RIGHT) {
				this.ballPos.x += dx;
			} else {
				this.ballPos.x -= dx;
			}
			if (this.myYDirection == VerticalDirection.DOWN) {
				this.ballPos.y += dy;
			} else {
				this.ballPos.y -= dy;
			}
			this.ball.draw(canvas);
		}
		
		public void onWindowResize(int w, int h) {
			hight = h;
			width = w;
		}

		public void waitForExit() {
			this.stop = true;
			try {
				join();
			} catch (InterruptedException ex) {
			}
		}
		
		public void changeSizeAndSpeed(){
			dx = dx == SLOW ? FAST : SLOW;
			dy = dx;
			size = size == SMALL ? BIG : SMALL;
		}
	}

	public void changeSizeAndSpeed() {
		drawingThread.changeSizeAndSpeed();
	}
}