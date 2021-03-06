/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se.kth.swim.msg.net;

import se.kth.swim.msg.Ping;
import se.sics.kompics.network.Header;
import se.sics.p2ptoolbox.util.network.NatedAddress;

/**
 *
 * @author fabriziodemaria
 */
public class NetNewParent extends NetMsg<Ping> {

    public NetNewParent(NatedAddress src, NatedAddress dst, NatedAddress newParent) {
        super(src, dst, new Ping(newParent));
    }

    private NetNewParent(Header<NatedAddress> header, Ping content) {
        super(header, content);
    }

    @Override
    public NetMsg copyMessage(Header<NatedAddress> newHeader) {
        return new NetNewParent(newHeader, getContent());
    }

}