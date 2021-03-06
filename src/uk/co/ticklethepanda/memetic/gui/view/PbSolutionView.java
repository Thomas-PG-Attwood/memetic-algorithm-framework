package uk.co.ticklethepanda.memetic.gui.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import uk.co.ticklethepanda.memetic.problem.generators.pbf.QuadraticPbFunctionGenerator;
import uk.co.ticklethepanda.memetic.problem.solutions.pbf.BitString;
import uk.co.ticklethepanda.memetic.problem.solutions.pbf.BitStringFactory;
import uk.co.ticklethepanda.memetic.problem.solutions.pbf.PsuedoBooleanFunction;

public class PbSolutionView extends SolutionView<BitString> {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private static final int DEFAULT_SIZE = 500;

  public static void main(final String[] args) {
    final PsuedoBooleanFunction function =
        new QuadraticPbFunctionGenerator(10000).generateFunction();

    final BitString solution = new BitStringFactory(function).generateSolution();

    final PbSolutionView solutionView = new PbSolutionView();

    solutionView.setSolution(solution);

    SwingUtilities.invokeLater(() -> {
      final JFrame jframe = new JFrame();
      jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ;
      jframe.getContentPane().add(solutionView);
      jframe.pack();
      jframe.setVisible(true);
    });

  }

  private BitString solution = null;

  public PbSolutionView() {
    setPreferredSize(new Dimension(DEFAULT_SIZE, DEFAULT_SIZE));
  }

  @Override
  public void paint(final Graphics g) {
    super.paint(g);

    // Set anti-alias!
    ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_OFF);

    if (solution != null) {
      final int xmargin = 30;
      final int ymargin = 30;

      final int actualWidth = getWidth() - xmargin;
      final int actualHeight = getHeight() - ymargin;

      final float drawStartX = xmargin / 2f;
      final float drawStartY = ymargin / 2f;

      final int nrows_pre = solution.size() / actualWidth + 2;
      final int ncols = solution.size() / nrows_pre;
      int nrows = nrows_pre;
      if (nrows_pre * ncols < solution.size()) {
        nrows++;
      }

      final float boxWidth = (float) actualWidth / (float) ncols;
      final float boxHeight = (float) actualHeight / (float) nrows;

      for (int i = 0; i < solution.size(); i++) {

        final float x = i % ncols;
        final float y = i / ncols;
        final float startX = drawStartX + x * boxWidth;
        final float startY = drawStartY + y * boxHeight;
        final float width = boxWidth;
        final float height = boxHeight;

        if (solution.get(i)) {
          g.setColor(Color.BLACK);
        } else {
          g.setColor(Color.LIGHT_GRAY);
        }

        final Shape line = new Rectangle2D.Float(startX, startY, width, height);
        ((Graphics2D) g).fill(line);
      }
    }
  }

  @Override
  public void setSolution(final BitString solution) {
    this.solution = solution;
    this.repaint();
  }

}
