package de.gandev.modjn.example;

import de.gandev.modjn.ModbusClient;
import de.gandev.modjn.ModbusServer;
import de.gandev.modjn.entity.exception.ConnectionException;
import de.gandev.modjn.entity.exception.ErrorResponseException;
import de.gandev.modjn.entity.exception.NoResponseException;
import de.gandev.modjn.entity.func.Util;
import de.gandev.modjn.entity.func.WriteSingleCoil;
import de.gandev.modjn.entity.func.WriteSingleRegister;
import de.gandev.modjn.entity.func.request.ReadCoilsRequest;
import de.gandev.modjn.entity.func.request.ReadDiscreteInputsRequest;
import de.gandev.modjn.entity.func.request.ReadHoldingRegistersRequest;
import de.gandev.modjn.entity.func.request.ReadInputRegistersRequest;
import de.gandev.modjn.entity.func.request.WriteMultipleCoilsRequest;
import de.gandev.modjn.entity.func.request.WriteMultipleRegistersRequest;
import de.gandev.modjn.entity.func.response.ReadCoilsResponse;
import de.gandev.modjn.entity.func.response.ReadDiscreteInputsResponse;
import de.gandev.modjn.entity.func.response.ReadHoldingRegistersResponse;
import de.gandev.modjn.entity.func.response.ReadInputRegistersResponse;
import de.gandev.modjn.entity.func.response.WriteMultipleCoilsResponse;
import de.gandev.modjn.entity.func.response.WriteMultipleRegistersResponse;
import de.gandev.modjn.handler.ModbusRequestHandler;
import java.util.BitSet;
import javax.swing.JOptionPane;

/**
 *
 * @author ares
 */
public class ModbusExampleUI extends javax.swing.JFrame {

    private static ModbusClient modbusClient;
    private static ModbusServer modbusServer;

    /**
     * Creates new form ModbusTCPExampleUI
     */
    public ModbusExampleUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pConnection = new javax.swing.JPanel();
        btListen = new javax.swing.JButton();
        tfHost = new javax.swing.JTextField();
        tfPort = new javax.swing.JTextField();
        btConnect = new javax.swing.JButton();
        tfRemotePort = new javax.swing.JTextField();
        lbClient = new javax.swing.JLabel();
        lbClients = new javax.swing.JLabel();
        btReadCoils = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taLog = new javax.swing.JTextArea();
        tfAddr = new javax.swing.JTextField();
        tfQuantity = new javax.swing.JTextField();
        btReadDiscreteInputs = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btListen.setText("listen");
        btListen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListenActionPerformed(evt);
            }
        });

        tfHost.setText("10.0.1.55");

        tfPort.setText("30502");

        btConnect.setText("connect");
        btConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConnectActionPerformed(evt);
            }
        });

        tfRemotePort.setText("502");

        lbClient.setText("not connected");

        lbClients.setText("0 clients connected");

        javax.swing.GroupLayout pConnectionLayout = new javax.swing.GroupLayout(pConnection);
        pConnection.setLayout(pConnectionLayout);
        pConnectionLayout.setHorizontalGroup(
            pConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pConnectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pConnectionLayout.createSequentialGroup()
                        .addComponent(lbClient, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbClients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfPort)
                    .addComponent(tfRemotePort, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btConnect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btListen, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pConnectionLayout.setVerticalGroup(
            pConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pConnectionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btListen)
                    .addComponent(tfPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbClients))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pConnectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConnect)
                    .addComponent(tfRemotePort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbClient))
                .addContainerGap())
        );

        btReadCoils.setText("ReadCoils");
        btReadCoils.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReadCoilsActionPerformed(evt);
            }
        });

        taLog.setColumns(20);
        taLog.setRows(5);
        jScrollPane1.setViewportView(taLog);

        tfAddr.setText("12288");

        tfQuantity.setText("10");

        btReadDiscreteInputs.setText("ReadDiscreteInputs");
        btReadDiscreteInputs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReadDiscreteInputsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 185, Short.MAX_VALUE)
                        .addComponent(pConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btReadCoils)
                            .addComponent(btReadDiscreteInputs))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAddr, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btReadCoils)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btReadDiscreteInputs))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfAddr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btListenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListenActionPerformed
        String port = tfPort.getText();

        if (modbusServer != null) {
            modbusServer.close();
        }

        modbusServer = new ModbusServer(Integer.valueOf(port), new ModbusRequestHandler() {

            @Override
            protected WriteSingleCoil writeSingleCoil(WriteSingleCoil request) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected WriteSingleRegister writeSingleRegister(WriteSingleRegister request) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected ReadCoilsResponse readCoilsRequest(ReadCoilsRequest request) {
                BitSet coils = new BitSet(request.getQuantityOfCoils());

                for (int i = 0; i < request.getQuantityOfCoils(); i++) {
                    coils.set(i);
                }

                return new ReadCoilsResponse(coils);
            }

            @Override
            protected ReadDiscreteInputsResponse readDiscreteInputsRequest(ReadDiscreteInputsRequest request) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected ReadInputRegistersResponse readInputRegistersRequest(ReadInputRegistersRequest request) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected ReadHoldingRegistersResponse readHoldingRegistersRequest(ReadHoldingRegistersRequest request) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected WriteMultipleRegistersResponse writeMultipleRegistersRequest(WriteMultipleRegistersRequest request) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            protected WriteMultipleCoilsResponse writeMultipleCoilsRequest(WriteMultipleCoilsRequest request) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }); //ModbusConstants.MODBUS_DEFAULT_PORT);

        try {
            modbusServer.setup();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
        }
    }//GEN-LAST:event_btListenActionPerformed

    private void btConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConnectActionPerformed
        if (modbusClient != null) {
            modbusClient.close();
        }

        String host = tfHost.getText();
        String port = tfRemotePort.getText();

        modbusClient = new ModbusClient(host, Integer.valueOf(port)); //ModbusConstants.MODBUS_DEFAULT_PORT);

        try {
            modbusClient.setup();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage());
        }

        lbClient.setText("connected");
    }//GEN-LAST:event_btConnectActionPerformed

    private void btReadCoilsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReadCoilsActionPerformed
        if (modbusClient == null) {
            lbClient.setText("not connected");
            return;
        }

        int addr = Integer.parseInt(tfAddr.getText());
        int quantity = Integer.parseInt(tfQuantity.getText());

        ReadCoilsResponse readCoils;
        try {
            readCoils = modbusClient.readCoils(addr, quantity);

            if (readCoils == null) {
                modbusClient = null;
            } else {
                taLog.append(Util.getBinaryString(readCoils.getByteCount(), readCoils.getCoilStatus()) + "\n");
            }
        } catch (NoResponseException | ErrorResponseException | ConnectionException ex) {
            taLog.append(ex.getLocalizedMessage() + "\n");
        }
    }//GEN-LAST:event_btReadCoilsActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (modbusServer != null) {
            modbusServer.close();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btReadDiscreteInputsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReadDiscreteInputsActionPerformed
        if (modbusClient == null) {
            lbClient.setText("not connected");
            return;
        }

        int addr = Integer.parseInt(tfAddr.getText());
        int quantity = Integer.parseInt(tfQuantity.getText());

        ReadDiscreteInputsResponse readDiscreteInputs;
        try {
            readDiscreteInputs = modbusClient.readDiscreteInputs(addr, quantity);

            if (readDiscreteInputs == null) {
                modbusClient = null;
            } else {
                taLog.append(Util.getBinaryString(readDiscreteInputs.getByteCount(), readDiscreteInputs.getInputStatus()) + "\n");
            }
        } catch (NoResponseException | ErrorResponseException | ConnectionException ex) {
            taLog.append(ex.getLocalizedMessage() + "\n");
        }
    }//GEN-LAST:event_btReadDiscreteInputsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModbusExampleUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConnect;
    private javax.swing.JButton btListen;
    private javax.swing.JButton btReadCoils;
    private javax.swing.JButton btReadDiscreteInputs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbClient;
    private javax.swing.JLabel lbClients;
    private javax.swing.JPanel pConnection;
    private javax.swing.JTextArea taLog;
    private javax.swing.JTextField tfAddr;
    private javax.swing.JTextField tfHost;
    private javax.swing.JTextField tfPort;
    private javax.swing.JTextField tfQuantity;
    private javax.swing.JTextField tfRemotePort;
    // End of variables declaration//GEN-END:variables
}
