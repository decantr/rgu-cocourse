/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cocourse.server.gui;

import cocourse.Auction;
import cocourse.server.Server;

import javax.swing.*;
import java.text.SimpleDateFormat;

/**
 * @author decanter
 */
public class ServerGUI extends javax.swing.JFrame {

	private long startTime;
	private Auction auction;
	private Server server;
	private Timer timer;
	private int logline = 0;

	/**
	 * Creates new form serverfront
	 */
	public ServerGUI( ) {

		startTime = System.currentTimeMillis( );

		if ( server == null ) {
			NewServerGUI d = new NewServerGUI( this , true , this.server );
			d.setVisible( true );
			server = d.getServer( );
		}

		server.start( );


		timer = new javax.swing.Timer( 100 , e -> {
			if ( server.isRunning( ) ) {

				while ( logline < server.getLog( ).size( ) ) {
					txtLog.append( server.getLog( ).get( logline ).toString( ) + "\n" );
					logline++;
				}

				this.txtTime.setText(
						new SimpleDateFormat( "hh:mm:ss" ).format( System.currentTimeMillis( ) ) );

				if ( this.server.getAuction( ) != null && this.server.getAuction( ).isRunning( ) ) {

					this.txtTimeLeft.setText(
							new SimpleDateFormat( "mm:ss" ).format( this.server.getAuction( ).timeLeft( ) ) );

					this.txtHighestBid.setText( "" + this.server.getAuction( ).getBidHigh( ).getAmount( ) );

					this.txtHighestBidder.setText( this.server.getAuction( ).getBidHigh( ).getUser( ) );
				}
			}
		} );

		initComponents( );

		pnlInfo.setVisible( false );

		timer.start( );

		this.txtIp.setText( "" + server.getIp( ).toString( ) );
	}

	void swap( ) {
		pnlInfo.setVisible( !pnlInfo.isVisible( ) );
		btnNew.setVisible( !btnNew.isVisible( ) );
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents( ) {

		jPanel2 = new javax.swing.JPanel( );
		jScrollPane1 = new javax.swing.JScrollPane( );
		txtLog = new javax.swing.JTextArea( );
		lblLog = new javax.swing.JLabel( );
		jScrollPane2 = new javax.swing.JScrollPane( );
		txtUsers = new javax.swing.JTextArea( );
		lblUsers = new javax.swing.JLabel( );
		jSeparator1 = new javax.swing.JSeparator( );
		lblIp = new javax.swing.JLabel( );
		txtIp = new javax.swing.JTextField( );
		txtTime = new javax.swing.JTextField( );
		jLabel1 = new javax.swing.JLabel( );
		pnlWrap = new javax.swing.JPanel( );
		pnlInfo = new javax.swing.JPanel( );
		txtHighestBid = new javax.swing.JTextField( );
		lblHighestBidder = new javax.swing.JLabel( );
		txtHighestBidder = new javax.swing.JTextField( );
		txtTimeLeft = new javax.swing.JTextField( );
		lblTimeLeft = new javax.swing.JLabel( );
		lblHighestBid = new javax.swing.JLabel( );
		btnStartAuction = new javax.swing.JButton( );
		jLabel2 = new javax.swing.JLabel( );
		txtAuctionName = new javax.swing.JTextField( );
		btnNew = new javax.swing.JButton( );

		setDefaultCloseOperation( javax.swing.WindowConstants.EXIT_ON_CLOSE );

		txtLog.setEditable( false );
		txtLog.setColumns( 20 );
		txtLog.setRows( 5 );
		jScrollPane1.setViewportView( txtLog );

		lblLog.setText( "log" );

		jScrollPane2.setHorizontalScrollBarPolicy( javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );

		txtUsers.setEditable( false );
		txtUsers.setColumns( 20 );
		txtUsers.setRows( 4 );
		txtUsers.setTabSize( 1 );
		jScrollPane2.setViewportView( txtUsers );

		lblUsers.setText( "users" );
		lblUsers.setVerticalAlignment( javax.swing.SwingConstants.TOP );

		lblIp.setText( "ip address" );

		txtIp.setEditable( false );

		txtTime.setEditable( false );

		jLabel1.setText( "Current Time" );

		txtHighestBid.setEditable( false );

		lblHighestBidder.setText( "higest bidder" );

		txtHighestBidder.setEditable( false );

		txtTimeLeft.setEditable( false );

		lblTimeLeft.setText( "time left" );

		lblHighestBid.setText( "highest bid" );

		btnStartAuction.setText( "Start" );
		btnStartAuction.addActionListener( new java.awt.event.ActionListener( ) {
			public void actionPerformed( java.awt.event.ActionEvent evt ) {
				btnStartAuctionActionPerformed( evt );
			}
		} );

		jLabel2.setText( "Item Name" );

		txtAuctionName.setEditable( false );

		javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout( pnlInfo );
		pnlInfo.setLayout( pnlInfoLayout );
		pnlInfoLayout.setHorizontalGroup(
				pnlInfoLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
						.addGroup( pnlInfoLayout.createSequentialGroup( )
								.addContainerGap( )
								.addGroup( pnlInfoLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
										.addComponent( lblHighestBid )
										.addComponent( lblHighestBidder )
										.addComponent( jLabel2 ) )
								.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED )
								.addGroup( pnlInfoLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING , false )
										.addGroup( pnlInfoLayout.createSequentialGroup( )
												.addComponent( txtHighestBid , javax.swing.GroupLayout.PREFERRED_SIZE , 38 , javax.swing.GroupLayout.PREFERRED_SIZE )
												.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
												.addComponent( lblTimeLeft )
												.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
												.addComponent( txtTimeLeft , javax.swing.GroupLayout.PREFERRED_SIZE , 76 , javax.swing.GroupLayout.PREFERRED_SIZE ) )
										.addComponent( btnStartAuction )
										.addComponent( txtHighestBidder )
										.addComponent( txtAuctionName ) )
								.addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE ) )
		);
		pnlInfoLayout.setVerticalGroup(
				pnlInfoLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
						.addGroup( pnlInfoLayout.createSequentialGroup( )
								.addComponent( btnStartAuction )
								.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED , 15 , Short.MAX_VALUE )
								.addGroup( pnlInfoLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
										.addComponent( txtTimeLeft , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE )
										.addComponent( lblTimeLeft )
										.addComponent( lblHighestBid )
										.addComponent( txtHighestBid , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE ) )
								.addGap( 8 , 8 , 8 )
								.addGroup( pnlInfoLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
										.addComponent( jLabel2 )
										.addComponent( txtAuctionName , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE ) )
								.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
								.addGroup( pnlInfoLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
										.addComponent( lblHighestBidder )
										.addComponent( txtHighestBidder , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE ) )
								.addContainerGap( ) )
		);

		btnNew.setText( "New Auction" );
		btnNew.addActionListener( new java.awt.event.ActionListener( ) {
			public void actionPerformed( java.awt.event.ActionEvent evt ) {
				btnNewActionPerformed( evt );
			}
		} );

		javax.swing.GroupLayout pnlWrapLayout = new javax.swing.GroupLayout( pnlWrap );
		pnlWrap.setLayout( pnlWrapLayout );
		pnlWrapLayout.setHorizontalGroup(
				pnlWrapLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
						.addComponent( pnlInfo , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE )
						.addGroup( pnlWrapLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
								.addGroup( pnlWrapLayout.createSequentialGroup( )
										.addGap( 103 , 103 , 103 )
										.addComponent( btnNew , javax.swing.GroupLayout.PREFERRED_SIZE , 123 , javax.swing.GroupLayout.PREFERRED_SIZE )
										.addContainerGap( 74 , Short.MAX_VALUE ) ) )
		);
		pnlWrapLayout.setVerticalGroup(
				pnlWrapLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
						.addGroup( pnlWrapLayout.createSequentialGroup( )
								.addContainerGap( )
								.addComponent( pnlInfo , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE )
								.addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE ) )
						.addGroup( pnlWrapLayout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
								.addGroup( pnlWrapLayout.createSequentialGroup( )
										.addGap( 42 , 42 , 42 )
										.addComponent( btnNew , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE )
										.addGap( 42 , 42 , 42 ) ) )
		);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout( jPanel2 );
		jPanel2.setLayout( jPanel2Layout );
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
						.addGroup( jPanel2Layout.createSequentialGroup( )
								.addContainerGap( )
								.addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
										.addGroup( jPanel2Layout.createSequentialGroup( )
												.addGap( 12 , 12 , 12 )
												.addComponent( jSeparator1 , javax.swing.GroupLayout.PREFERRED_SIZE , 448 , javax.swing.GroupLayout.PREFERRED_SIZE )
												.addContainerGap( javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE ) )
										.addGroup( jPanel2Layout.createSequentialGroup( )
												.addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
														.addGroup( jPanel2Layout.createSequentialGroup( )
																.addGroup( jPanel2Layout
																		.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING , false )
																		.addGroup( javax.swing.GroupLayout.Alignment.TRAILING , jPanel2Layout
																				.createSequentialGroup( )
																				.addComponent( lblIp )
																				.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
																				.addComponent( txtIp )
																				.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.UNRELATED )
																				.addComponent( jLabel1 )
																				.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
																				.addComponent( txtTime , javax.swing.GroupLayout.PREFERRED_SIZE , 100 , javax.swing.GroupLayout.PREFERRED_SIZE ) )
																		.addComponent( lblLog )
																		.addGroup( jPanel2Layout.createSequentialGroup( )
																				.addComponent( pnlWrap , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE )
																				.addGap( 0 , 0 , 0 )
																				.addComponent( lblUsers )
																				.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
																				.addComponent( jScrollPane2 , javax.swing.GroupLayout.DEFAULT_SIZE , 132 , Short.MAX_VALUE ) ) )
																.addGap( 0 , 0 , Short.MAX_VALUE ) )
														.addComponent( jScrollPane1 ) )
												.addContainerGap( ) ) ) )
		);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
						.addGroup( javax.swing.GroupLayout.Alignment.TRAILING , jPanel2Layout.createSequentialGroup( )
								.addGap( 0 , 0 , 0 )
								.addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.BASELINE )
										.addComponent( txtTime , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE )
										.addComponent( jLabel1 )
										.addComponent( txtIp , javax.swing.GroupLayout.PREFERRED_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE )
										.addComponent( lblIp ) )
								.addGap( 4 , 4 , 4 )
								.addComponent( jSeparator1 , javax.swing.GroupLayout.PREFERRED_SIZE , 10 , javax.swing.GroupLayout.PREFERRED_SIZE )
								.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
								.addGroup( jPanel2Layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING , false )
										.addComponent( jScrollPane2 )
										.addComponent( pnlWrap , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.PREFERRED_SIZE )
										.addGroup( jPanel2Layout.createSequentialGroup( )
												.addGap( 12 , 12 , 12 )
												.addComponent( lblUsers ) ) )
								.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE )
								.addComponent( lblLog )
								.addPreferredGap( javax.swing.LayoutStyle.ComponentPlacement.RELATED )
								.addComponent( jScrollPane1 , javax.swing.GroupLayout.PREFERRED_SIZE , 183 , javax.swing.GroupLayout.PREFERRED_SIZE )
								.addContainerGap( ) )
		);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout( getContentPane( ) );
		getContentPane( ).setLayout( layout );
		layout.setHorizontalGroup(
				layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
						.addGroup( javax.swing.GroupLayout.Alignment.TRAILING , layout.createSequentialGroup( )
								.addContainerGap( )
								.addComponent( jPanel2 , javax.swing.GroupLayout.DEFAULT_SIZE , javax.swing.GroupLayout.DEFAULT_SIZE , Short.MAX_VALUE )
								.addContainerGap( ) )
		);
		layout.setVerticalGroup(
				layout.createParallelGroup( javax.swing.GroupLayout.Alignment.LEADING )
						.addGroup( javax.swing.GroupLayout.Alignment.TRAILING , layout.createSequentialGroup( )
								.addContainerGap( )
								.addComponent( jPanel2 , javax.swing.GroupLayout.PREFERRED_SIZE , 390 , Short.MAX_VALUE ) )
		);

		pack( );
	}// </editor-fold>//GEN-END:initComponents

	private void btnNewActionPerformed( java.awt.event.ActionEvent evt ) {//GEN-FIRST:event_btnNewActionPerformed

		NewAuctionGUI a = new NewAuctionGUI( this , true );
		a.setVisible( true );

		server.setAuction( a.getAuction( ) );

		swap( );

		this.txtAuctionName.setText( this.server.getAuction( ).getName( ) );
		this.txtHighestBid.setText( "" + this.server.getAuction( ).getBidHigh( ) );
	}//GEN-LAST:event_btnNewActionPerformed

	private void btnStartAuctionActionPerformed( java.awt.event.ActionEvent evt ) {//GEN-FIRST:event_btnStartAuctionActionPerformed
		server.startAuction( );
		this.btnStartAuction.setEnabled( false );
	}//GEN-LAST:event_btnStartAuctionActionPerformed


	/**
	 * @param args the command line arguments
	 */
	public static void main( String args[] ) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for ( javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels( ) ) {
				if ( "Nimbus".equals( info.getName( ) ) ) {
					javax.swing.UIManager.setLookAndFeel( info.getClassName( ) );
					break;
				}
			}
		} catch ( ClassNotFoundException ex ) {
			java.util.logging.Logger.getLogger( ServerGUI.class.getName( ) )
					.log( java.util.logging.Level.SEVERE , null , ex );
		} catch ( InstantiationException ex ) {
			java.util.logging.Logger.getLogger( ServerGUI.class.getName( ) )
					.log( java.util.logging.Level.SEVERE , null , ex );
		} catch ( IllegalAccessException ex ) {
			java.util.logging.Logger.getLogger( ServerGUI.class.getName( ) )
					.log( java.util.logging.Level.SEVERE , null , ex );
		} catch ( javax.swing.UnsupportedLookAndFeelException ex ) {
			java.util.logging.Logger.getLogger( ServerGUI.class.getName( ) )
					.log( java.util.logging.Level.SEVERE , null , ex );
		}
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater( ( ) -> new ServerGUI( ).setVisible( true ) );

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnNew;
	private javax.swing.JButton btnStartAuction;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JLabel lblHighestBid;
	private javax.swing.JLabel lblHighestBidder;
	private javax.swing.JLabel lblIp;
	private javax.swing.JLabel lblLog;
	private javax.swing.JLabel lblTimeLeft;
	private javax.swing.JLabel lblUsers;
	private javax.swing.JPanel pnlInfo;
	private javax.swing.JPanel pnlWrap;
	private javax.swing.JTextField txtAuctionName;
	private javax.swing.JTextField txtHighestBid;
	private javax.swing.JTextField txtHighestBidder;
	private javax.swing.JTextField txtIp;
	private javax.swing.JTextArea txtLog;
	private javax.swing.JTextField txtTime;
	private javax.swing.JTextField txtTimeLeft;
	private javax.swing.JTextArea txtUsers;
	// End of variables declaration//GEN-END:variables
}
