import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/*
  Unit test for Piece class -- starter shell.
 */
public class PieceTest {
	// You can create data to be used in the your
	// test cases like this. For each run of a test method,
	// a new PieceTest object is created and setUp() is called
	// automatically by JUnit.
	// For example, the code below sets up some
	// pyramid and s pieces in instance variables
	// that can be used in tests.
	private Piece pyr1, pyr2, pyr3, pyr4;
	private Piece s, sRotated;
	
	private Piece stick, stick2, stick3, stick4, stick5;

	@Before
	public void setUp() throws Exception {
		
		pyr1 = new Piece(Piece.PYRAMID_STR);
		pyr2 = pyr1.computeNextRotation();
		pyr3 = pyr2.computeNextRotation();
		pyr4 = pyr3.computeNextRotation();
		
		s = new Piece(Piece.S1_STR);
		sRotated = s.computeNextRotation();
		
		 Piece[] pieces = Piece.getPieces();
		 stick = pieces[Piece.STICK];	
		 stick2 = stick.fastRotation();
		 stick3 = stick2.fastRotation();
		 stick4 = stick3.fastRotation();
		 stick5 = stick4.fastRotation();
	}
	
	// Here are some sample tests to get you started
	
	@Test
	public void testSampleSize() {
		// Check size of pyr piece
		assertEquals(3, pyr1.getWidth());
		assertEquals(2, pyr1.getHeight());
		
		// Now try after rotation
		// Effectively we're testing size and rotation code here
		assertEquals(2, pyr2.getWidth());
		assertEquals(3, pyr2.getHeight());
		
		assertEquals(3, pyr3.getWidth());
		assertEquals(2, pyr3.getHeight());

		assertEquals(2, pyr4.getWidth());
		assertEquals(3, pyr4.getHeight());
		
		// Now try with some other piece, made a different way
		Piece l = new Piece(Piece.STICK_STR);
		assertEquals(1, l.getWidth());
		assertEquals(4, l.getHeight());
	}
	
	// Test the skirt returned by a few pieces
	@Test
	public void testSampleSkirt() {
		// Note must use assertTrue(Arrays.equals(... as plain .equals does not work
		// right for arrays.
		
		System.out.println(pyr1.getSkirt()[1]);
		assertTrue(Arrays.equals(new int[] {0, 0, 0}, pyr1.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0}, pyr2.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0, 1}, pyr3.getSkirt()));
		assertTrue(Arrays.equals(new int[] {0, 1}, pyr4.getSkirt()));
		
		assertTrue(Arrays.equals(new int[] {0, 0, 1}, s.getSkirt()));
		assertTrue(Arrays.equals(new int[] {1, 0}, sRotated.getSkirt()));
	}
	
	@Test
	public void testFastRotation(){
		assertEquals(1, stick.getWidth());
		assertEquals(4, stick.getHeight());
		assertTrue(Arrays.equals(new int[] {0}, stick.getSkirt()));
		
		assertEquals(4, stick2.getWidth());
		assertEquals(1, stick2.getHeight());
		assertTrue(Arrays.equals(new int[] {0,0,0,0}, stick2.getSkirt()));
	
		assertEquals(1, stick3.getWidth());
		assertEquals(4, stick3.getHeight());
		assertTrue(Arrays.equals(new int[] {0}, stick3.getSkirt()));

		assertEquals(4, stick4.getWidth());
		assertEquals(1, stick4.getHeight());
		assertTrue(Arrays.equals(new int[] {0,0,0,0}, stick4.getSkirt()));

		assertEquals(1, stick5.getWidth());
		assertEquals(4, stick5.getHeight());
		assertTrue(Arrays.equals(new int[] {0}, stick5.getSkirt()));
		
		assertTrue(!stick.equals(stick2));
		assertTrue(!stick.equals(stick3));
		assertTrue(!stick.equals(stick4));
		assertTrue(stick.equals(stick5));
		assertEquals(stick, stick5);
		assertEquals(stick, stick4.fastRotation());
		
	}
	
	
}
