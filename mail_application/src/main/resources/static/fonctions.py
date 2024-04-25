from cryptography.fernet import Fernet
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives import hashes
from cryptography.hazmat.primitives.kdf.pbkdf2 import PBKDF2HMAC
import sys

key_fernet = Fernet('Ws60ZimICxiK_Mh2opu9QLRmx05gKZgtI_1y9jtv-R0=')
salt = bytes.fromhex("824267da38ba259062ef900413f82c53")
def hash_password(password,salt):
    kdf = PBKDF2HMAC(algorithm=hashes.SHA256(), length=32, salt=salt, iterations=1000, backend=default_backend())
    key = kdf.derive(password.encode())
    digest = hashes.Hash(hashes.SHA256(),backend=default_backend())
    digest.update(key)
    hashed_password = digest.finalize()
    return hashed_password


def verify_password(password, salt, hashed_password):
    kdf = PBKDF2HMAC(algorithm=hashes.SHA256(), length=32, salt=salt, iterations=1000, backend=default_backend())
    key = kdf.derive(password.encode())
    digest = hashes.Hash(hashes.SHA256(),backend=default_backend())
    digest.update(key)
    generated_hash = digest.finalize()
    return generated_hash == hashed_password


def crypter_message(mail, key_fernet):
    return key_fernet.encrypt(mail)


def decrypter_message(mail_crypter, key_fernet):
    return key_fernet.decrypt(mail_crypter)

c = hash_password(sys.argv[1],salt).hex()
print(c,end="")