package com.app.core.atm;

public interface Transport {
  void communicateWithBank(byte[] pkt);
}
