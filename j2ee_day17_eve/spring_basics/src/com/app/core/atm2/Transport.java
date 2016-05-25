package com.app.core.atm2;

public interface Transport {
  void communicateWithBank(byte[] pkt);
}
