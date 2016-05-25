package com.app.core.atm3;

public interface Transport {
  void communicateWithBank(byte[] pkt);
}
