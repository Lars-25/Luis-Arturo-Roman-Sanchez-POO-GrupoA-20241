class Book:
    def __init__(self, title):
        self.title = title
        self.renter = None

    def get_title(self):
        return self.title

    def get_renter(self):
        return self.renter

    def set_renter(self, renter):
        self.renter = renter
